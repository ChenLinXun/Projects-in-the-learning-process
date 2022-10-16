package com.feng.ioc.beanControlTest;

import com.feng.ioc.bean.Actor;
import com.feng.ioc.bean.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 自动装配测试
 */
public class Test05 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //自动装配：byName
        Actor act = (Actor) context.getBean("act");
        System.out.println(act);

        //自动装配：byType
        Student student = (Student) context.getBean("student");
        System.out.println(student);

    }
}
