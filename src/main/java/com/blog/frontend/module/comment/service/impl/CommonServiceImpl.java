package com.blog.frontend.module.comment.service.impl;

import com.blog.frontend.common.Constant;
import com.blog.frontend.common.PageDTO;
import com.blog.frontend.exception.BaseException;
import com.blog.frontend.exception.ErrorCodeEnum;
import com.blog.frontend.module.comment.dao.ICommentDao;
import com.blog.frontend.module.comment.entity.CommentDTO;
import com.blog.frontend.module.comment.entity.CommentPO;
import com.blog.frontend.module.comment.entity.CommentQuery;
import com.blog.frontend.module.comment.service.ICommentService;
import com.blog.frontend.module.paper.service.IPaperService;
import com.blog.frontend.util.CommonUtils;
import com.blog.frontend.util.PageUtils;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/12/4
 */
@Service
public class CommonServiceImpl implements ICommentService {

    @Autowired
    private ICommentDao commentDao;
    @Autowired
    private IPaperService paperService;

    @Override
    public void createCommentOnPaper(CommentDTO commentDTO) throws BaseException {
        if (null == paperService.getPaperDetail(commentDTO.getPaperId())) {
            throw new BaseException(ErrorCodeEnum.OBJECT_NON_EXISTENCE, Constant.PAPER_DISPLAY_NAME);
        }

        CommentPO commentPO = CommonUtils.copyBean(commentDTO, CommentPO.class);
        commentDao.createCommentOnPaper(commentPO);
    }

    @Override
    public void updateComment(CommentDTO commentDTO) throws BaseException {
        if (null == paperService.getPaperDetail(commentDTO.getPaperId())) {
            throw new BaseException(ErrorCodeEnum.OBJECT_NON_EXISTENCE, Constant.PAPER_DISPLAY_NAME);
        }

        CommentPO commentPO = CommonUtils.copyBean(commentDTO, CommentPO.class);

        if (0 == commentDao.updateComment(commentPO)) {
            throw new BaseException(ErrorCodeEnum.OBJECT_NON_EXISTENCE, Constant.COMMENT_DISPLAY_NAME);
        }
    }

    @Override
    public PageDTO<CommentDTO> listCommentsByPaperId(CommentQuery commentQuery) throws BaseException {

        PageUtils.paging(commentQuery);
        Page<CommentPO> commentList = commentDao.listCommentsByPaperId(commentQuery);

        return new PageDTO<>(commentList.getTotal(), CommonUtils.copyBeanList(commentList, CommentDTO.class));
    }

    @Override
    public void deleteComment(Integer id) throws BaseException {
        if (0 == commentDao.deleteComment(id)) {
            throw new BaseException(ErrorCodeEnum.OBJECT_NON_EXISTENCE, Constant.COMMENT_DISPLAY_NAME);
        }
    }
}
