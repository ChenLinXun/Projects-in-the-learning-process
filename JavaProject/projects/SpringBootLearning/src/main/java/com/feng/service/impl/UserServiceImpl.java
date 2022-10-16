package com.feng.service.impl;

import com.feng.mapper.UserMapper;
import com.feng.pojo.User;
import com.feng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int saveUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int updateUserImage(String userImage) {
        return userMapper.updateUserImage(userImage);
    }
}
