package com.feng.mapper;

import com.feng.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component(value = "UserMapper")
public interface UserMapper {

    /**
     * 查询所有用户基本信息
     * @return List<User>
     */
    List<User> queryUsers();

    int insertUser(User user);

    User queryByName(@Param("userName") String userName);
}