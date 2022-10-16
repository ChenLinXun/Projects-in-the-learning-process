package com.feng.service;

import com.feng.pojo.User;

public interface UserService {
    int saveUser(User user);
    int updateUserImage(String userImage);
}
