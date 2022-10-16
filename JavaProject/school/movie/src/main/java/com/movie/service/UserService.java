package com.movie.service;

import com.movie.pojo.User;

public interface UserService {

    //插入一条用户信息（注册）
    String insertUser(User user);

    //查询一条用户信息（登录）
    User selectUser(User user);
}
