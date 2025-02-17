package com.yishui.usercenter.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用返回类
 *
 * @param <T>
 */
@Data
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = 3185729783037429416L;

    private int code;

    private T data;

    private String message;

    private String description;


    public BaseResponse(int code, T data, String message,String description) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.description = description;
    }

    public BaseResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = "";
        this.description = "";
    }

    public BaseResponse(int code, T data) {
        this.code = code;
        this.data = data;
        this.message = "";
        this.description = "";

    }

    public BaseResponse(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.data = null;
        this.description = errorCode.getDescription();
    }

    public BaseResponse(ErrorCode errorCode,String description) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.data = null;
        this.description = description;
    }
}
