package com.yishui.usercenter.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yishui.usercenter.common.BaseResponse;
import com.yishui.usercenter.common.ErrorCode;
import com.yishui.usercenter.common.ResultUtils;
import com.yishui.usercenter.exception.BusinessException;
import com.yishui.usercenter.model.domain.User;
import com.yishui.usercenter.model.domain.request.UserLoginRequest;
import com.yishui.usercenter.model.domain.request.UserRegisterRequest;
import com.yishui.usercenter.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

import static com.yishui.usercenter.constant.UserConstant.ADMIN_ROLE;
import static com.yishui.usercenter.constant.UserConstant.USER_LOGIN_STATE;

/**
 * 用户接口
 *
 * @author yishui
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    public BaseResponse<Long> userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
        if (userRegisterRequest == null) {
//            return ResultUtils.error(ErrorCode.PARAMS_ERROR);
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        String planetCode = userRegisterRequest.getPlanetCode();
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword,planetCode)) {
            return ResultUtils.error(ErrorCode.NULL_ERROR);
        }
        long result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        return ResultUtils.success(result);
    }

    @PostMapping("/login")
    public BaseResponse<User> userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {
        if (userLoginRequest == null) {
            return null;
        }
        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            return null;
        }
        User user = userService.userLogin(userAccount, userPassword, request);
        return ResultUtils.success(user);
    }

    @PostMapping("/logOut")
    public BaseResponse<Integer> userLogOut(HttpServletRequest request) {
        if (request == null) {
            return null;
        }

        int i = userService.userLogout(request);
        return ResultUtils.success(i);
    }

    @GetMapping("/search")
    public BaseResponse<List<User>> searchUsers(String username, HttpServletRequest request) {
        if(!isAdmin(request)){
//            return ResultUtils.success(new ArrayList<User>());
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        if(StringUtils.isNotBlank(username)){
            queryWrapper.like("username", username);
        }
        List<User> userList = userService.list(queryWrapper);
        return ResultUtils.success(userList.stream().map(user -> userService.getSafetyUser(user)).collect(Collectors.toList()));
    }

    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteUser(@RequestBody long id,HttpServletRequest request) {
        if(!isAdmin(request)){
            return null;
        }

        if (id <= 0) {
            return null;
        }
        return ResultUtils.success(userService.removeById(id));
    }

    private boolean isAdmin(HttpServletRequest request){
        // 仅管理员可查询
        Object userObject = request.getSession().getAttribute(USER_LOGIN_STATE);
        User user = userObject ==   null ? null : (User) userObject;
        if (user == null || user.getUserRole() != ADMIN_ROLE) {
            return false;
        }
        return true;
    }

}
