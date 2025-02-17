package com.yishui.usercenter.exception;

import com.yishui.usercenter.common.BaseResponse;
import com.yishui.usercenter.common.ErrorCode;
import com.yishui.usercenter.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public BaseResponse businessExceptionHandler(BusinessException e) {
        log.error("businessException: {}", e.getMessage(), e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR,e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResponse runtimeExceptionHandler(RuntimeException e) {
        log.error("runtimeException", e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR,e.getMessage());
    }


}
