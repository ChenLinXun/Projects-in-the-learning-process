package com.feng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 处理首页，因为加入了静态资源前缀，只能通过自定义Controller(使用了Thymeleaf模板引擎，取消了静态资源前缀的配置)
 */
@Controller
public class Index {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
