package com.blog.frontend.module.like.dao;

import com.blog.frontend.module.entity.LikePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/11/20
 */
@Mapper
public interface ILikeDao {

    /**
     * TODO
     *
     * @param likePO like对象
     * @return java.lang.Integer
     * @author JerryGao
     * @date 2019/11/20 23:57
     */
    Integer createLike(LikePO likePO);

    /**
     * TODO
     *
     * @param paperId 文章id
     * @return java.lang.Integer
     * @author JerryGao
     * @date 2019/11/21 0:01
     */
    LikePO getLikeByPaperId(@Param("paperId") Integer paperId);
}
