package com.blog.frontend.module.menu.dao;

import com.blog.frontend.module.menu.entity.MenuDTO;
import com.blog.frontend.module.menu.entity.MenuPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/12/2
 */
@Mapper
public interface IMenuDao {

    /**
     * 获取menu列表
     *
     * @return java.util.List<com.blog.frontend.module.menu.entity.MenuPO>
     * @author JerryGao
     * @date 2019/12/3 0:01
     */
    List<MenuPO> listMenu();
}
