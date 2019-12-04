package com.blog.frontend.module.comment.service;

import com.blog.frontend.common.PageDTO;
import com.blog.frontend.exception.BaseException;
import com.blog.frontend.module.comment.entity.CommentDTO;
import com.blog.frontend.module.comment.entity.CommentPO;
import com.blog.frontend.module.comment.entity.CommentQuery;
import com.blog.frontend.module.paper.entity.PaperQuery;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import javax.xml.stream.events.Comment;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/12/4
 */
public interface ICommentService {
    /**
     * TODO
     *
     * @param commentDTO 评论
     * @author JerryGao
     * @date 2019/12/4 22:09
     */
    void createCommentOnPaper(CommentDTO commentDTO) throws BaseException;

    /**
     * TODO
     *
     * @param commentDTO
     * @author JerryGao
     * @date 2019/12/4 22:09
     */
    void updateComment(CommentDTO commentDTO) throws BaseException;

    /**
     * TODO
     *
     * @param commentQuery
     * @return PageDTO
     * @author JerryGao
     * @date 2019/12/4 22:09
     */
    PageDTO<CommentDTO> listCommentsByPaperId(CommentQuery commentQuery) throws BaseException;

    /**
     * TODO
     *
     * @param id
     * @author JerryGao
     * @date 2019/12/4 22:09
     */
    void deleteComment(Integer id) throws BaseException;
}
