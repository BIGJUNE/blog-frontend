package com.blog.frontend.module.menu.service.impl;

import com.blog.frontend.exception.BaseException;
import com.blog.frontend.module.menu.dao.IMenuDao;
import com.blog.frontend.module.menu.entity.MenuDTO;
import com.blog.frontend.module.menu.entity.MenuPO;
import com.blog.frontend.module.menu.service.IMenuService;
import com.blog.frontend.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/12/3
 */
@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private IMenuDao menuDao;

    @Override
    public List<MenuDTO> listMenu() throws BaseException {

        List<MenuPO> menuPOList = menuDao.listMenu();

        return CommonUtils.copyBeanList(menuPOList, MenuDTO.class);
    }
}
