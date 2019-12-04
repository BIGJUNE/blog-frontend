package com.blog.frontend.module.comment.dao;

import com.blog.frontend.common.BaseQuery;
import com.blog.frontend.module.comment.entity.CommentPO;
import com.blog.frontend.module.comment.entity.CommentQuery;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/12/4
 */
@Mapper
public interface ICommentDao {
    /**
     * TODO
     * 
     * @param commentPO 评论
     * @return java.lang.Integer
     * @author JerryGao
     * @date 2019/12/4 22:09 
     */
    Integer createCommentOnPaper(CommentPO commentPO);
    
    /**
     * TODO
     * 
     * @param commentPO
     * @return java.lang.Integer
     * @author JerryGao
     * @date 2019/12/4 22:09 
     */
    Integer updateComment(CommentPO commentPO);
    
    /**
     * TODO
     * 
     * @param commentQuery
     * @return com.github.pagehelper.Page<com.blog.frontend.module.comment.entity.CommentPO>
     * @author JerryGao
     * @date 2019/12/4 22:09 
     */
    Page<CommentPO> listCommentsByPaperId(CommentQuery commentQuery);
    
    /**
     * TODO
     *
     * @param id
     * @return java.lang.Integer
     * @author JerryGao
     * @date 2019/12/4 22:09 
     */
    Integer deleteComment(@Param("id") Integer id);
}
