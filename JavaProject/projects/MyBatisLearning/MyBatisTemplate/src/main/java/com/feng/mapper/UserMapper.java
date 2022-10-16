package com.feng.mapper;

import com.feng.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     * 查询所有用户
     * @return
     */
    List<User> selectAll();

    /**
     * 根据账号密码查询
     * @param map
     * @return
     */
    @Deprecated
    List<User> selectByUP(Map map);

    /**
     * 根据账号密码查询
     * @param username
     * @param password
     * @return
     */
    User selectByUserNameAndPassword(
            @Param("username")String username,
            @Param("password")String password);
}
