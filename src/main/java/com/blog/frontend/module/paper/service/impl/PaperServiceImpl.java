package com.blog.frontend.module.paper.service.impl;

import com.blog.frontend.common.PageDTO;
import com.blog.frontend.exception.BaseException;
import com.blog.frontend.module.paper.dao.IPaperDao;
import com.blog.frontend.module.paper.entity.dto.PaperBasicDTO;
import com.blog.frontend.module.paper.entity.dto.PaperDetailDTO;
import com.blog.frontend.module.paper.entity.PaperQuery;
import com.blog.frontend.module.paper.entity.po.PaperVO;
import com.blog.frontend.module.paper.service.IPaperService;
import com.blog.frontend.module.tag.service.ITagService;
import com.blog.frontend.util.CommonUtils;
import com.blog.frontend.util.PageUtils;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
