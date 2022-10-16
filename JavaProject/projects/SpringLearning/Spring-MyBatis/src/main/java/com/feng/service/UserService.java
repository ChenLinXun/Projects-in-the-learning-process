package com.feng.service;

import com.feng.pojo.User;

import java.util.List;

public interface UserService {

    List<User> listUsers();

    List<User> insertAndListUsers(User user);

}
