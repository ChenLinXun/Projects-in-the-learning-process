package com.movie.service.impl;

import com.movie.mapper.UserDetailsMapper;
import com.movie.mapper.UserMapper;
import com.movie.pojo.User;
import com.movie.pojo.UserDetails;
import com.movie.service.UserService;
import com.movie.utils.UUIDutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@SuppressWarnings("all")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDetailsMapper userDetailsMapper;

    @Override
    @Transactional
    public String insertUser(User user) {

        //判断昵称和密码是否为空
        if ("".equals(user.getUserName()) || "".equals(user.getUserAccount())
                || "".equals(user.getUserPassword())){
            return "字段不能为空";
        }

        //验证注册昵称是否重复
        String s = userMapper.selectUserByName(user.getUserName());
        if (s != null){
            //说明数据库中已有该昵称
            return "昵称重复";
        }

        //验证注册邮箱是否重复
        String ss = userMapper.selectUserByAccount(user.getUserAccount());
        if (ss != null){
            //说明数据库中已有该邮箱
            return "邮箱重复";
        }

        //以下两步应该是事务处理：

        //1.处理用户表：
        //  获取并注入用户编号UUID
        String userId = UUIDutils.getId();
        user.setUserId(userId);
        //插入数据
        userMapper.insertUser(user);

        //2.处理用户详情表：
        //  获取用户详情编号UUID
        String detailsId = UUIDutils.getId();
        UserDetails userDetails = new UserDetails();
        userDetails.setDetailsId(detailsId);
        userDetails.setDetailsUid(userId);
        //  插入数据
        userDetailsMapper.insertDetails(userDetails);

        return "注册成功";
    }

    @Override
    public User selectUser(User user) {
        User user1 = userMapper.selectUser(user);
        if (user1 != null){
            user1.setUserPassword("");
        }
        return user1;
    }
}
