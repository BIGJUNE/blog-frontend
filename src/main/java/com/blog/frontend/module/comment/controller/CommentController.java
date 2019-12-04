package com.blog.frontend.module.comment.controller;

import com.blog.frontend.common.PageDTO;
import com.blog.frontend.common.RespResult;
import com.blog.frontend.exception.BaseException;
import com.blog.frontend.module.comment.entity.CommentDTO;
import com.blog.frontend.module.comment.entity.CommentQuery;
import com.blog.frontend.module.comment.service.ICommentService;
import com.blog.frontend.module.paper.entity.PaperQuery;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/12/4
 */
@RequestMapping("/v1")
@RestController
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @PostMapping("{paperId}/comments")
    public RespResult createCommentOnPaper(@PathVariable("paperId") Integer paperId, @RequestBody CommentDTO commentDTO) throws BaseException {
        commentDTO.setPaperId(paperId);
        commentService.createCommentOnPaper(commentDTO);

        return RespResult.success();
    }

    @PutMapping("/comments/{commentId}")
    public RespResult updateComment(@PathVariable("commentId") Integer commentId, @RequestBody CommentDTO commentDTO) throws BaseException {

        commentDTO.setId(commentId);
        commentService.updateComment(commentDTO);

        return RespResult.success();
    }

    @GetMapping("{paperId}/comments")
    public RespResult<PageDTO<CommentDTO>> listCommentsByPaperId(@PathVariable("paperId") Integer paperId,
                                                     @RequestParam("cur_page") Integer curPage,
                                                     @RequestParam("per_page") Integer perPage,
                                                     @RequestParam("sort_column") String sortColumn,
                                                     @RequestParam("sort_direction") String sortDirection) throws BaseException {

        CommentQuery commentQuery = new CommentQuery(paperId);
        commentQuery.setCurPage(curPage);
        commentQuery.setPerPage(perPage);
        commentQuery.setSortColumn(sortColumn);
        commentQuery.setSortDirection(sortDirection);

        return RespResult.success(commentService.listCommentsByPaperId(commentQuery));

    }

    @DeleteMapping("/comments/{commentId}")
    public RespResult deleteComment(@PathVariable("commentId") Integer commentId) throws BaseException {
        commentService.deleteComment(commentId);

        return RespResult.success();
    }
}
