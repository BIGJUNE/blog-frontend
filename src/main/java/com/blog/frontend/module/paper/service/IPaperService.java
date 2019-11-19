package com.blog.frontend.module.paper.service;

import com.blog.frontend.common.PageDTO;
import com.blog.frontend.exception.BaseException;
import com.blog.frontend.module.paper.entity.dto.PaperBasicDTO;
import com.blog.frontend.module.paper.entity.dto.PaperDetailDTO;
import com.blog.frontend.module.paper.entity.PaperQuery;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/11/16
 */
public interface IPaperService {

    /**
     * 查询文章基础信息列表
     *
     * @param paperQuery 查询参数
     * @return 查询结果
     * @author JerryGao
     * @date 2019/11/16 15:37
     * @throws BaseException 通用异常
     */
    PageDTO<PaperBasicDTO> listPaperBasic(PaperQuery paperQuery) throws BaseException;

    /**
     * 根据id获取文章的详情信息
     *
     * @param id 文章的id
     * @return 返回文章的详情信息
     * @author JerryGao
     * @date 2019/11/16 15:38
     * @throws BaseException 通用异常
     */
    PaperDetailDTO getPaperDetail(Integer id) throws BaseException;
    
    /**
     * TODO
     * 
     * @param paperDetailDTO
     * @return void
     * @author JerryGao
     * @date 2019/11/20 0:41
     */
    void createPaper(PaperDetailDTO paperDetailDTO);
        
}
