package com.blog.frontend.module.paper.dao;

import com.blog.frontend.module.paper.entity.dto.PaperBasicDTO;
import com.blog.frontend.module.paper.entity.dto.PaperDetailDTO;
import com.blog.frontend.module.paper.entity.PaperQuery;
import com.blog.frontend.module.paper.entity.po.PaperVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IPaperDao {

    /**
     * 查询文章基础信息列表
     *
     * @param paperQuery 查询参数
     * @return 查询结果
     * @author JerryGao
     * @date 2019/11/16 15:37
     */
    Page<PaperVO> listPaperBasic(PaperQuery paperQuery);

    /**
     * 根据id获取文章的详情信息
     *
     * @param id 文章的id
     * @return 返回文章的详情信息
     * @author JerryGao
     * @date 2019/11/16 15:38
     */
    PaperVO getPaperDetail(@Param("id") Integer id);

    /**
     * 创建文章
     *
     * @param paperVO
     * @return java.lang.Integer
     * @author JerryGao
     * @date 2019/11/20 22:59
     */
    Integer createPaper(PaperVO paperVO);
}
