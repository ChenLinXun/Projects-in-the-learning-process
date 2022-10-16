package com.feng.ioc.beanControlTest;

import com.feng.ioc.bean.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring IoC 管理类实例
 */
public class Test03 {
    public static void main(String[] args) {

        //通过Spring容器创建Student类对象
        //1. 初始化Spring容器，加载Spring配置文件
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //2. 通过Spring容器创建Actor类对象
        Student stu = (Student) context.getBean("stu");
        System.out.println(stu);
    }
}
