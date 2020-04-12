package com.blog.frontend.module.user.service;

import com.blog.frontend.exception.BaseException;
import com.blog.frontend.module.user.entity.UserDTO;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2020/4/12
 */
public interface IUserService {
    /**
     * 验证登录
     *
     * @param userDTO 用户信息dto
     * @return 验证结果
     */
    void validateLogin(UserDTO userDTO) throws BaseException;
}
