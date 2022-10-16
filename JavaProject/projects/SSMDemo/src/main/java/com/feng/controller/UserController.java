package com.feng.controller;

import com.feng.pojo.User;
import com.feng.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam("userName") String userName,
                      @RequestParam("password") String password){

        ModelAndView modelAndView = new ModelAndView();
        User user = userService.userLogin(userName, password);
        if (user != null) {
            modelAndView.setViewName("/success.jsp");
            modelAndView.addObject("user",user);
        }else {
            modelAndView.setViewName("/index.jsp");
            modelAndView.addObject("tips","用户名或密码错误！");
        }
        return modelAndView;
    }

}
