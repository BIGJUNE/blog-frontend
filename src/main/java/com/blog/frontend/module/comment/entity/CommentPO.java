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
@NoArgsConstructor
@AllArgsConstructor
public class CommentPO {
    private Integer id;
    private Integer paperId;
    private String content;
    private Integer replyCommentId;
    private String createTime;
    private Integer userId;
    private Integer active;
    private Integer enable;
    private String updateTime;
}
