package com.blog.frontend.module.paper.service;

import com.blog.frontend.common.HomeDTO;
import com.blog.frontend.common.PageDTO;
import com.blog.frontend.exception.BaseException;
import com.blog.frontend.module.paper.entity.dto.PaperSimpleDTO;
import com.blog.frontend.module.paper.entity.dto.PaperDetailDTO;
import com.blog.frontend.module.paper.entity.PaperQuery;

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
    PageDTO<PaperSimpleDTO> listPaperBasic(PaperQuery paperQuery) throws BaseException;

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
     * 创建文章
     * 
     * @param paperDetailDTO
     * @author JerryGao
     * @date 2019/11/20 0:41
     * @throws BaseException 通用异常
     */
    Integer createPaper(PaperDetailDTO paperDetailDTO) throws BaseException;

    /**
     * 编辑文章
     *
     * @param paperDetailDTO
     * @author JerryGao
     * @date 2019/11/20 0:41
     * @throws BaseException 通用异常
     */
    void updatePaper(PaperDetailDTO paperDetailDTO) throws BaseException;

    /**
     * 删除文章
     *
     * @param paperId 文章的id
     * @author JerryGao
     * @date 2019/11/25 0:49
     */
    void deletePaper(Integer paperId) throws BaseException;

    /**
     * 激活or禁用一篇文章
     *
     * @param paperId 文章id
     * @author JerryGao
     * @date 2019/11/25 0:50
     */
    void enablePaper(Integer paperId) throws BaseException;

    /**
     * 查询首页
     *
     * @return com.blog.frontend.common.HomeDTO
     * @author JerryGao
     * @date 2019/12/21 11:32
     */
    HomeDTO listHomePapers() throws BaseException;
        
}
