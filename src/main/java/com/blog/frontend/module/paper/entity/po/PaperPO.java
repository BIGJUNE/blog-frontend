package com.blog.frontend.module.paper.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 文章po，对应paper表
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/11/16
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaperPO {
    private Integer id;
    private String title;
    private String summary;
    private String text;
    private String createTime;
    private String updateTime;
    private Integer active;
    private Integer enable;

}
