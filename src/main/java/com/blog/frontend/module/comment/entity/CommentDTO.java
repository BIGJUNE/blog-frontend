package com.blog.frontend.module.comment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/12/4
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private Integer id;
    private Integer paperId;
    private String content;
    private String createTime;
    private String updateTime;
    private Integer enable;
    private String userId;
}
