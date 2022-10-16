package com.feng.service;

import com.feng.pojo.User;

public interface UserService {

    /**
     * 用户登录服务
     * @return
     */
    User userLogin(String userName, String userPassword);

}
