package com.yishui.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yishui.usercenter.model.domain.User;

import javax.servlet.http.HttpServletRequest;

/**
* @author a1480
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2024-12-16 15:14:54
*/
public interface UserService extends IService<User> {

    // 用户登录
    public static final String USER_LOGIN_STATE = "userLoginState";

    /**
     * 用户注册
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @param checkPassword 校验密码
     * @return 新用户 id
     */
    long userRegister(String userAccount,String userPassword,String checkPassword);

    /**
     *
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @return 脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);
}

