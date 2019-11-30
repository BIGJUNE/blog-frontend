package com.blog.frontend.module.paper.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/11/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaperPO {
    private Integer id;
    private String title;
    private String creatTime;
    private String updateTime;
    private Integer active;
    private Integer enable;
    private String summary;
    private Integer readCount;
    private Integer menuId;
    private String text;
}
