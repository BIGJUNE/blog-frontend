package com.blog.frontend.module.user.entity;

import lombok.Data;

import java.util.Date;

/**
 * 用户po
 *
 * @author JerryGao 415309574@qq.com
 * @date 2020/4/12
 */
@Data
public class UserPO {
    private String username;
    private String password;
    private Date createTime;
    private Date updateTime;
}
