package com.blog.frontend.module.tag.controller;

import com.blog.frontend.common.PageDTO;
import com.blog.frontend.common.RespResult;
import com.blog.frontend.module.tag.entity.TagPO;
import com.blog.frontend.module.tag.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/11/18
 */
@RestController
@RequestMapping("/v1/tags")
public class TagController {
    @Autowired
    private ITagService tagService;

    @GetMapping
    public RespResult<PageDTO<String>> listTags(@RequestParam(value = "tag_name", required = false) String tagName) {
        return RespResult.success(tagService.listTagsByTagName(tagName));
    }
}
