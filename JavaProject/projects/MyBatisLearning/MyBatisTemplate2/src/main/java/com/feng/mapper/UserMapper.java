package com.feng.mapper;

import com.feng.pojo.User;

public interface UserMapper {

    /**
     * 添加用户基本信息
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 根据用户名查询用户基本信息
     * @param name
     * @return
     */
    User queryUser(String name);

    /**
     * 利用连接查询：
     * 根据用户名查询用户基本信息以及详细信息
     * @param name
     * @return
     */
    User queryUserVsDetail(String name);

    /**
     * 利用子查询：
     * 根据用户名查询用户基本信息以及详细信息
     * @param name
     * @return
     */
    User queryUserVsDetail2(String name);

}
