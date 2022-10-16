package com.feng.service.impl;

import com.feng.mapper.UserMapper;
import com.feng.pojo.User;
import com.feng.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource//自动装配，当Spring容器创建UserMapper对象时，自动装配给userMapper
    private UserMapper userMapper;

    /**
     * 用户登录服务
     * @param userName
     * @return
     */
    public User userLogin(String userName,String password) {
        User user = userMapper.selectAllByUserName(userName);
        if(user != null){
            if (user.getUserPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

}
