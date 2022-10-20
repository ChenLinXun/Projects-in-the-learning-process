package com.feng.controller;

import com.feng.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//日志
@Slf4j
public class Hello {

    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car car(){
        return car;
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam("name") String name){
        log.info("用户："+ name +" 进来了...");
        return "hello,world! "+name;
    }
}
