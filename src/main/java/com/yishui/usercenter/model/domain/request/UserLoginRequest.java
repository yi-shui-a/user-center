package com.yishui.usercenter.model.domain.request;


import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求体
 *
 * @author yishui
 */
@Data
public class UserLoginRequest implements Serializable {


    private static final long serialVersionUID = 3298320637240692179L;
    private String userAccount;

    private String userPassword;

}
