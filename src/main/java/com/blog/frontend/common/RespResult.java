package com.blog.frontend.common;

import com.blog.frontend.exception.BaseException;
import com.github.pagehelper.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

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

    private final static int SUCCESS_CODE = 0;
    private final static String SUCCESS_MESSAGE = "OK";

    private int code;
    private String message;
    private T data;

    private RespResult(T data) {
        this.code = SUCCESS_CODE;
        this.message = SUCCESS_MESSAGE;
        this.data = data;
    }

    public static<T> RespResult<PageDTO<T>> pageResult(Page<T> dataList) {
        PageDTO<T> pageDTO = new PageDTO<>(dataList.getTotal(), dataList);
        return new RespResult<>(pageDTO);
    }

    public static RespResult success() {
        return new RespResult<>(null);
    }

    public static <T> RespResult<T> success(T data) {
        return new RespResult<>(data);
    }

    public static RespResult error(BaseException ex) {
        return new RespResult<>(ex.getErrorCode(), ex.getMessage(), null);
    }
}
