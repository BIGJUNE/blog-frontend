package com.blog.frontend.module.user.controller;

import com.blog.frontend.common.RespResult;
import com.blog.frontend.exception.BaseException;
import com.blog.frontend.interceptor.login.LoginRequire;
import com.blog.frontend.module.user.entity.UserDTO;
import com.blog.frontend.module.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2020/4/12
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public RespResult login(HttpSession httpSession, @RequestBody @Validated UserDTO userDTO) throws BaseException {
        userService.validateLogin(userDTO);
        httpSession.setAttribute("username", userDTO.getUsername());
        return RespResult.success();
    }

    @GetMapping("/test")
    @LoginRequire
    public RespResult testLogin(HttpSession httpSession) {
        String username = (String) httpSession.getAttribute("username");
        return RespResult.success(username);
    }
}
