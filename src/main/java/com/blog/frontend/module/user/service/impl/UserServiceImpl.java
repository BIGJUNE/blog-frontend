package com.blog.frontend.module.user.service.impl;

import com.blog.frontend.exception.BaseException;
import com.blog.frontend.exception.ErrorCodeEnum;
import com.blog.frontend.module.user.dao.IUserDao;
import com.blog.frontend.module.user.entity.UserDTO;
import com.blog.frontend.module.user.entity.UserPO;
import com.blog.frontend.module.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2020/4/12
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public void validateLogin(UserDTO userDTO) throws BaseException {
        UserPO userInfo = userDao.getUser(userDTO.getUsername());
        if (userInfo == null) {
            throw new BaseException(ErrorCodeEnum.LOGIN_FAILED);
        }
        if (!userDTO.getPassword().equals(userInfo.getPassword())) {
            throw new BaseException(ErrorCodeEnum.LOGIN_FAILED);
        }
    }
}
