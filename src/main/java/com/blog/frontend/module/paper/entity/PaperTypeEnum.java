package com.blog.frontend.module.paper.entity;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/12/21
 */
public enum PaperTypeEnum {
    BLOG(1, "博客"),
    NOTE(2, "笔记")
    ;

    private Integer code;
    private String message;

    PaperTypeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
