package com.blog.frontend.module.like.service;

import com.blog.frontend.exception.BaseException;
import com.blog.frontend.module.entity.LikePO;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/11/21
 */
public interface ILikeService {

    /**
     * TODO
     *
     * @param likePO like对象
     * @return void
     * @author JerryGao
     * @date 2019/11/21 0:14
     */
    void createLike(LikePO likePO) throws BaseException;

    /**
     * TODO
     *
     * @param paperId 文章Id
     * @return com.blog.frontend.module.entity.LikePO
     * @author JerryGao
     * @date 2019/11/21 0:16
     */
    LikePO getLikeByPaperId(Integer paperId);
}
