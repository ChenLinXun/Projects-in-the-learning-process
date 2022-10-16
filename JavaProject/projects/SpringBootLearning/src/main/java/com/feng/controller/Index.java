package com.feng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 处理首页，因为加入了静态资源前缀，只能通过自定义Controller(使用了Thymeleaf模板引擎，取消了静态资源前缀的配置)
 */
@Controller
public class Index {
    @RequestMapping("/")
    public String index(HttpSession session, Model model){
        Object notLoggedIn = session.getAttribute("NotLoggedIn");
        if (notLoggedIn != null){
            session.removeAttribute("NotLoggedIn");
            model.addAttribute("NotLoggedIn",notLoggedIn);
        }
        return "index";
    }
}
