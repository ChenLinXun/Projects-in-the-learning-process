package com.feng.service.impl;

import com.feng.pojo.User;
import com.feng.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mvc.xml","classpath:spring-context.xml","classpath:spring-mybatis.xml"})
public class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Test
    public void userLogin() {
        User user = userService.userLogin("zhangsan", "123123");
        System.out.println(user);
    }
}