package com.blog.frontend.module.paper.service.impl;

import com.blog.frontend.module.paper.entity.dto.PaperBasicDTO;
import com.blog.frontend.module.paper.entity.dto.PaperDetailDTO;
import com.blog.frontend.module.paper.entity.PaperQuery;
import com.blog.frontend.module.paper.service.IPaperService;
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

    @Override
    public List<PaperBasicDTO> listPaperBasic(PaperQuery paperQuery) {
        return null;
    }

    @Override
    public PaperDetailDTO getPaperDetail(Integer id) {
        return null;
    }
}
