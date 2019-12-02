package com.blog.frontend.module.menu.controller;

import com.blog.frontend.common.RespResult;
import com.blog.frontend.exception.BaseException;
import com.blog.frontend.module.menu.entity.MenuDTO;
import com.blog.frontend.module.menu.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/12/3
 */
@RestController
@RequestMapping("/v1/menus")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @GetMapping
    public RespResult<List<MenuDTO>> listMenu() throws BaseException {
        return RespResult.success(menuService.listMenu());
    }
}
