package com.blog.frontend.module.like.service.impl;

import com.blog.frontend.exception.BaseException;
import com.blog.frontend.exception.ErrorCodeEnum;
import com.blog.frontend.module.like.entity.LikePO;
import com.blog.frontend.module.like.dao.ILikeDao;
import com.blog.frontend.module.like.service.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/11/21
 */
@Service
public class LikeServiceImpl implements ILikeService {

    @Autowired
    private ILikeDao likeDao;

    @Override
    public void createLike(LikePO likePO) throws BaseException {
        if (likeDao.getLikeByPaperId(likePO.getPaperId()) != null) {
            throw new BaseException(ErrorCodeEnum.OBJECT_REPEAT, "文章的点赞数");
        }

        likeDao.createLike(likePO);
    }

    @Override
    public LikePO getLikeByPaperId(Integer paperId) {
        return likeDao.getLikeByPaperId(paperId);
    }
}
