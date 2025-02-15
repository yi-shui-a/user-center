package com.yishui.usercenter.model.domain.request;


import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author yishui
 */
@Data
public class UserRegisterRequest implements Serializable {


    private static final long serialVersionUID = 6234367206062614214L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;
}
