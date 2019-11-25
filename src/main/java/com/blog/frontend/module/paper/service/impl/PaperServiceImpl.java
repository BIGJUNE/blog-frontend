package com.blog.frontend.module.paper.service.impl;

import com.blog.frontend.common.Constant;
import com.blog.frontend.common.PageDTO;
import com.blog.frontend.exception.BaseException;
import com.blog.frontend.exception.ErrorCodeEnum;
import com.blog.frontend.module.like.entity.LikePO;
import com.blog.frontend.module.like.service.ILikeService;
import com.blog.frontend.module.paper.dao.IPaperDao;
import com.blog.frontend.module.paper.entity.dto.PaperBasicDTO;
import com.blog.frontend.module.paper.entity.dto.PaperDetailDTO;
import com.blog.frontend.module.paper.entity.PaperQuery;
import com.blog.frontend.module.paper.entity.po.PaperPO;
import com.blog.frontend.module.paper.entity.po.PaperVO;
import com.blog.frontend.module.paper.service.IPaperService;
import com.blog.frontend.module.tag.entity.TagPO;
import com.blog.frontend.module.tag.service.ITagService;
import com.blog.frontend.util.CommonUtils;
import com.blog.frontend.util.PageUtils;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/11/16
 */
@Service
public class PaperServiceImpl implements IPaperService {

    @Autowired
    private IPaperDao paperDao;

    @Autowired
    private ITagService tagService;

    @Autowired
    private ILikeService likeService;

    private static final int LIKE_DEFAULT_AMOUNT = 0;

    @Override
    public PageDTO<PaperBasicDTO> listPaperBasic(PaperQuery paperQuery) throws BaseException {

        PageUtils.paging(paperQuery);
        Page<PaperVO> paperVOList = paperDao.listPaperBasic(paperQuery);
        List<PaperBasicDTO> paperBasicDTOList = CommonUtils.copyBeanList(paperVOList, PaperBasicDTO.class);

        // 加上标签
        tagService.bindTags2PaperList(paperBasicDTOList);

        return new PageDTO<>(paperVOList.getTotal(), paperBasicDTOList);
    }

    @Override
    public PaperDetailDTO getPaperDetail(Integer id) throws BaseException {

        PaperVO paperVo = paperDao.getPaperDetail(id);
        PaperDetailDTO paperDetailDto = CommonUtils.copyBean(paperVo, PaperDetailDTO.class);

        // 加上标签
        tagService.bindTags2Paper(paperDetailDto);

        return paperDetailDto;
    }


    @Override
    public void createPaper(PaperDetailDTO paperDetailDTO) throws BaseException {
        PaperPO paperPO = CommonUtils.copyBean(paperDetailDTO, PaperPO.class);
        paperDao.createPaper(paperPO);

        // 创建标签
        if (!paperDetailDTO.getTagList().isEmpty()) {
            Integer paperId = paperDetailDTO.getId();
            List<TagPO> tagList = paperDetailDTO.getTagList()
                    .stream()
                    .map(tagName -> new TagPO(paperId, tagName))
                    .collect(Collectors.toList());
            tagService.createTag(tagList);
        }

        // 为文字创建点赞数
        likeService.createLike(new LikePO(paperDetailDTO.getId(), LIKE_DEFAULT_AMOUNT, Constant.VERSION_INIT));
    }

    @Override
    public void updatePaper(PaperDetailDTO paperDetailDTO) throws BaseException {
        PaperPO paperPO = CommonUtils.copyBean(paperDetailDTO, PaperPO.class);
        if (0 == paperDao.updatePaper(paperPO)) {
            throw new BaseException(ErrorCodeEnum.OBJECT_NON_EXISTENCE, "文章");
        }
    }

    @Override
    public void deletePaper(Integer paperId) throws BaseException {
        if (0 == paperDao.deletePaper(paperId)) {
            throw new BaseException(ErrorCodeEnum.OBJECT_NON_EXISTENCE, "文章");
        }
    }

    @Override
    public void enablePaper(Integer paperId) throws BaseException {
        if (0 == paperDao.enablePaper(paperId)) {
            throw new BaseException(ErrorCodeEnum.OBJECT_NON_EXISTENCE, "文章");
        }
    }
}
