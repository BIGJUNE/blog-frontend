package com.blog.frontend.module.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/11/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikePO {
    private Integer paperId;
    private Integer likeCount;
    private Integer version;
}
