package com.movie.controller;

import com.movie.pojo.User;
import com.movie.resp.IsLogin;
import com.movie.service.UserService;
import com.movie.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@SuppressWarnings("all")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 接口：插入一条用户信息（注册）
     * @param User
     * @return
     */
    @PostMapping("/addUser")
    public ResultJson<String> addUser(@RequestBody User user){
        String message = userService.insertUser(user);
        if("注册成功".equals(message)){
            return new ResultJson<String>
                    (200,true,message,user.getUserName());
        }else {
            return new ResultJson<String>
                    (400,false,message,user.getUserName());
        }
    }

    /**
     * 接口：查询一条用户信息（登录）
     * @param User
     * @return
     */
    @PostMapping("/login")
    public ResultJson<User> login(@RequestBody User user){
        User user1 = userService.selectUser(user);
        if(user1 != null){
            return new ResultJson<User>
                    (200,true,"登录成功",user1);
        }else {
            return new ResultJson<User>
                    (400,false,"登录失败",null);
        }
    }
}
