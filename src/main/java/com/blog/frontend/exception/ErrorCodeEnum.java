package com.blog.frontend.exception;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/11/18
 */
public enum ErrorCodeEnum {
    /*
     * 系统内部异常
     */
    UNKNOWN_EXCEPTION(-1, "系统内部异常"),

    OBJECT_REPEAT(-2, "%s已存在")
    ;
    private int code;
    private String message;

    ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
