package com.yishui.usercenter.common;

/**
 * 返回工具类
 */
public class ResultUtils {

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0, data, "ok");
    }

    public static <T> BaseResponse<T> error(ErrorCode errorCode) {
        return new BaseResponse<>(errorCode);
    }

    public static <T> BaseResponse<T> error(ErrorCode errorCode,String description) {
        return new BaseResponse<>(errorCode,description);
    }
}
