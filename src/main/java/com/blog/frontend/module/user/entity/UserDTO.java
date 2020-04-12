package com.blog.frontend.module.user.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2020/4/12
 */
@Data
public class UserDTO {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
