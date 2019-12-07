package com.blog.frontend.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 通用分页返回
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/11/18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageDTO<T> {
    private Long count;
    private List<T> list;
}
