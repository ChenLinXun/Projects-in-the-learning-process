package com.feng.service.impl;

import com.feng.mapper.UserMapper;
import com.feng.pojo.User;
import com.feng.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource//自动装配，当Spring容器创建UserMapper对象时，自动装配给userMapper
    private UserMapper userMapper;

    /**
     * 服务：
     * 查询全部用户信息
     * @return List<User>
     */
    public List<User> listUsers() {
        return userMapper.queryUsers();
    }

    /**
     * 服务：
     * 添加一个用户，并返回全部用户信息
     * @return List<User>
     */
    public List<User> insertAndListUsers(User user){
        User query = userMapper.queryByName(user.getUserName());
        if(query == null){
            userMapper.insertUser(user);
        }
        return userMapper.queryUsers();
    }
}
