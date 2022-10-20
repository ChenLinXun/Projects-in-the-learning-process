package com.feng.controller;

import com.feng.hello.service.HelloService;
import com.feng.pojo.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//日志
@Slf4j
public class HelloController {

    @Autowired
    Car car;

    //该组件为引入的自定义starter中的Service组件
    @Autowired
    HelloService helloService;

    @RequestMapping("/car")
    public Car car(){
        return car;
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam("name") String name){
        return helloService.sayHello(name);
    }
}
