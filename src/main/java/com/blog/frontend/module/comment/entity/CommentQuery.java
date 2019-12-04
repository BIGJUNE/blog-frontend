package com.blog.frontend.module.comment.entity;

import com.blog.frontend.common.BaseQuery;
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
public class CommentQuery extends BaseQuery {
    private Integer paperId;
}
