package com.blog.frontend.module.tag.entity;

import com.blog.frontend.common.BaseQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/11/19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagQuery extends BaseQuery {
    private Integer paperId;
    private String tagName;
}
