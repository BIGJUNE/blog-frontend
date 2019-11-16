package com.blog.frontend.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 接口统一返回类
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/11/16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespResult<T> {

    private final static int successCode = 0;
    private final static String successMessage = "OK";

    private int code;
    private String message;
    private T data;

    private RespResult(T data) {
        this.code = successCode;
        this.message = successMessage;
        this.data = data;
    }

    public static RespResult success() {
        return new RespResult<>(null);
    }

    public static<T> RespResult<T> success(T data){
        return new RespResult<>(data);
    }
}
