package com.blog.frontend.module.menu.service;

import com.blog.frontend.exception.BaseException;
import com.blog.frontend.module.menu.entity.MenuDTO;

import java.util.List;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/12/3
 */
public interface IMenuService {
    List<MenuDTO> listMenu() throws BaseException;
}
