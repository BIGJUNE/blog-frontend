package com.blog.frontend.module.user.dao;

import com.blog.frontend.module.user.entity.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2020/4/12
 */
@Mapper
public interface IUserDao {

    /**
     * 获取用户信息
     *
     * @param username 用户名
     * @return UserPO
     */
    UserPO getUser(@Param("username") String username);
}
