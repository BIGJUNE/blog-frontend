package com.blog.frontend.exception;

import com.blog.frontend.common.RespResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/11/18
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(BaseException.class)
    public RespResult handleBaseException(BaseException ex) {
        log(ex);
        return RespResult.error(ex);
    }

    @ExceptionHandler(Exception.class)
    public RespResult handleUnknownException(Exception ex) {
        log(ex);
        return new RespResult<>(ErrorCodeEnum.UNKNOWN_EXCEPTION.getCode(), ErrorCodeEnum.UNKNOWN_EXCEPTION.getMessage(), null);
    }

    private void log(Exception ex) {
        logger.error(ex.getMessage(), ex);
    }
}
