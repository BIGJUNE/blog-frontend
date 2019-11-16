package com.blog.frontend.module.paper.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 文字详情DTO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/11/16
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaperDetailDTO {
    private Integer id;
    private String title;
    private String text;
    private String createTime;
    private String updateTime;
    private String readCount;
    private String commentCount;
    private String likeCount;
    private List<String> tagList;
}
