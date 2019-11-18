package com.blog.frontend.module.tag.entity;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/11/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagPO {
    private Integer id;
    private Integer paperId;
    private String tagName;

    public TagPO(Integer paperId, String tagName) {
        this.paperId = paperId;
        this.tagName = tagName;
    }
}
