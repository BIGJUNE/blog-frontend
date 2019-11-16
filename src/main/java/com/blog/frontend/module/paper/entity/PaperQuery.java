package com.blog.frontend.module.paper.entity;

import com.blog.frontend.common.BasicQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
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
public class PaperQuery extends BasicQuery {
    private String title;
}
