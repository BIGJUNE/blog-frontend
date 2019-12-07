package com.blog.frontend.module.paper.service.impl;

import com.blog.frontend.common.Constant;
import com.blog.frontend.common.PageDTO;
import com.blog.frontend.exception.BaseException;
import com.blog.frontend.exception.ErrorCodeEnum;
import com.blog.frontend.module.like.service.ILikeService;
import com.blog.frontend.module.paper.dao.IPaperDao;
import com.blog.frontend.module.paper.entity.dto.PaperSimpleDTO;
import com.blog.frontend.module.paper.entity.dto.PaperDetailDTO;
import com.blog.frontend.module.paper.entity.PaperQuery;
import com.blog.frontend.module.paper.entity.po.PaperPO;
import com.blog.frontend.module.paper.entity.po.PaperVO;
import com.blog.frontend.module.paper.service.IPaperService;
import com.blog.frontend.module.tag.entity.TagPO;
import com.blog.frontend.module.tag.entity.TagQuery;
import com.blog.frontend.module.tag.service.ITagService;
import com.blog.frontend.util.CommonUtils;
import com.blog.frontend.util.PageUtils;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/11/16
 */
@Service
public class PaperServiceImpl implements IPaperService {

    public final static String OBJECT_NAME = "文章";

    @Autowired
    private IPaperDao paperDao;

    @Autowired
    private ITagService tagService;

    @Autowired
    private ILikeService likeService;

    private static final int LIKE_DEFAULT_AMOUNT = 0;

    private static final int SUMMARY_LENGTH = 90;

    @Override
    public PageDTO<PaperSimpleDTO> listPaperBasic(PaperQuery paperQuery) throws BaseException {

        PageUtils.paging(paperQuery);
        Page<PaperVO> paperVOList = paperDao.listPaperBasic(paperQuery);
        List<PaperSimpleDTO> paperSimpleDTOList = CommonUtils.copyBeanList(paperVOList, PaperSimpleDTO.class);

        // 加上标签
        tagService.bindTagsOnPapers(paperSimpleDTOList);

        return new PageDTO<>(paperVOList.getTotal(), paperSimpleDTOList);
    }

    @Override
    public PaperDetailDTO getPaperDetail(Integer id) throws BaseException {

        PaperVO paperVo = paperDao.getPaperDetail(id);

        if (Objects.isNull(paperVo)) {
            throw new BaseException(ErrorCodeEnum.OBJECT_NON_EXISTENCE, Constant.PAPER_DISPLAY_NAME);
        }

        PaperDetailDTO paperDetailDto = CommonUtils.copyBean(paperVo, PaperDetailDTO.class);
        tagService.bindTagsOnPaper(paperDetailDto);

        return paperDetailDto;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer createPaper(PaperDetailDTO paperDetailDTO) throws BaseException {
        PaperPO paperPO = CommonUtils.copyBean(paperDetailDTO, PaperPO.class);
        setPaperSummary(paperPO);
        paperDao.createPaper(paperPO);

        Integer paperId = paperPO.getId();
        // 创建标签
        if (!paperDetailDTO.getTagList().isEmpty()) {
            List<TagPO> tagList = paperDetailDTO.getTagList()
                    .stream()
                    .map(tagName -> new TagPO(paperId, tagName))
                    .collect(Collectors.toList());
            tagService.createTag(tagList);
        }

        return paperId;
    }

    @Override
    public void updatePaper(PaperDetailDTO paperDetailDTO) throws BaseException {
        PaperPO paperPO = CommonUtils.copyBean(paperDetailDTO, PaperPO.class);
        setPaperSummary(paperPO);
        if (0 == paperDao.updatePaper(paperPO)) {
            throw new BaseException(ErrorCodeEnum.OBJECT_NON_EXISTENCE, OBJECT_NAME);
        }

        // 更新tag
        tagService.deleteTagByPaperId(paperPO.getId());
        List<String> tagList = paperDetailDTO.getTagList();
        if (Objects.nonNull(tagList) && !tagList.isEmpty()) {
            List<TagPO> tagPOList = tagList.stream()
                    .map(tagName -> new TagPO(paperPO.getId(), tagName))
                    .collect(Collectors.toList());
            tagService.createTag(tagPOList);
        }

    }

    @Override
    public void deletePaper(Integer paperId) throws BaseException {
        if (0 == paperDao.deletePaper(paperId)) {
            throw new BaseException(ErrorCodeEnum.OBJECT_NON_EXISTENCE, OBJECT_NAME);
        }

    }

    @Override
    public void enablePaper(Integer paperId) throws BaseException {
        if (0 == paperDao.enablePaper(paperId)) {
            throw new BaseException(ErrorCodeEnum.OBJECT_NON_EXISTENCE, OBJECT_NAME);
        }
    }

    private void setPaperSummary(PaperPO paperPO) {
        int summaryLength = Math.min(SUMMARY_LENGTH, paperPO.getText().length());
        String summary = paperPO.getText().substring(0, summaryLength) + "...";
        paperPO.setSummary(summary);
    }
}
