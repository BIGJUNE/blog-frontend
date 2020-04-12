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

    OBJECT_REPEAT(-2, "%s已存在"),

    OBJECT_NON_EXISTENCE(-3, "%s不存在"),

    NOT_LOGIN(-4, "用户未登录"),

    LOGIN_FAILED(-5, "登录失败，用户名不存在或密码错误")
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
