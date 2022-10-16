package com.feng.controller;

import com.feng.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    @GetMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, HttpSession session, Model model){
        if(!StringUtils.isEmpty(user.getUserName()) && user.getPassword().equals("123")){
            session.setAttribute("loginUser",user);
            //重定向，防止表单重复提交
            return "redirect:main.html";
        }
        model.addAttribute("msg","账号或密码错误");
        return "login";
    }

    @GetMapping("/main.html")
    public String login(HttpSession session, Model model){
        User loginUser = (User)session.getAttribute("loginUser");
        if ( loginUser != null){
            model.addAttribute("userName",loginUser.getUserName());
            return "main";
        }
        return "login";
    }
}
