package com.blog.frontend.common;

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
@NoArgsConstructor
@AllArgsConstructor
public class BaseQuery {
    private Integer perPage;
    private Integer curPage;
    private String sortBy;
    private String sortDirection;
}
