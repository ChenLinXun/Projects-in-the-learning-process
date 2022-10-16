package com.movie.mapper;

import com.movie.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    //插入一条用户信息（注册）
    void insertUser(User user);

    //查询用户名（验证注册、登录）
    String selectUserByName(String userName);

    //查询邮箱（验证注册）
    String selectUserByAccount(String userAccount);

    //根据用户编号查询用户昵称
    String selectUserNameById(String userId);

    //查询一条用户信息（登录）
    User selectUser(User user);
}
