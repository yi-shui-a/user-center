package com.yishui.usercenter.exception;


import com.yishui.usercenter.common.ErrorCode;
import lombok.Getter;

/**
 * 自定义异常类
 */
@Getter
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -3246779724196710612L;
    private final int code;

    private final String description;

    public BusinessException(String message, int code, String description) {
        super(message);
        this.code = code;
        this.description = description;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.description = errorCode.getDescription();
    }

    public BusinessException(ErrorCode errorCode,String description) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.description = description;
    }

}
