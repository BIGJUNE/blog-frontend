package com.blog.frontend.exception;

/**
 * TODO
 *
 * @author JerryGao 415309574@qq.com
 * @date 2019/11/18
 */
public class BaseException extends Exception{

    private Integer errorCode;

    public BaseException() {
        super();
        this.errorCode = ErrorCodeEnum.UNKNOWN_EXCEPTION.getCode();
    }

    public BaseException(ErrorCodeEnum errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode.getCode();
    }

    public BaseException(ErrorCodeEnum errorCode, String additionalMsg) {
        super(String.format((errorCode.getMessage() + "(%s)"), additionalMsg));
        this.errorCode = errorCode.getCode();
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}
