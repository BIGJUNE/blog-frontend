package com.blog.frontend.module.paper.entity;

import com.blog.frontend.common.BaseQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/11/16
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PaperQuery extends BaseQuery {
    private String title;
    private Integer menuId;
}
