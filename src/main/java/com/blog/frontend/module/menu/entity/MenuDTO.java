package com.blog.frontend.module.menu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/12/2
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuDTO {
    private String menuName;
    private List<MenuDTO> subMenuList;
    private String url;
    private Integer level;
}
