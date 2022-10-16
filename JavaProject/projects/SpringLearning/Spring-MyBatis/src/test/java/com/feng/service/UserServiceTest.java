package com.feng.service;

import com.feng.pojo.User;
import junit.framework.TestCase;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserServiceTest extends TestCase {

    public void testListUsers() {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //如果被代理的目标对象实现了至少一个接口，Spring则会使用JDK动态代理
        //并且该类存在一个AOP的切入点方法，那么取到bean后必须强转成接口类型
        UserService userService = (UserService) context.getBean("userServiceImpl");

        List<User> users = userService.listUsers();
        System.out.println(users);
    }

    public void testInsertAndListUsers(){

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = (UserService) context.getBean("userServiceImpl");

        User user = new User();
        user.setUserName("hanmeimei");
        user.setUserPwd("123456");
        user.setUserRealName("韩梅梅");
        user.setUserImg("04.jpg");

        List<User> users = userService.insertAndListUsers(user);
        System.out.println(users);

    }
}