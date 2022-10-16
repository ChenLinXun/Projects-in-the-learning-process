package com.feng.ioc.beanControlTest;

import com.feng.ioc.bean.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean的作用域测试 和 Bean的声明周期方法测试
 */
public class Test04 {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //Spring容器加载，默认创建配置文件中的bean对象，此时book1被创建，打印

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        //book2为懒汉式，因此在调用其方法时才被创建：
        Book book2 = (Book) context.getBean("book2");

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        //book3不是单例模式，当获取多次book3对象，都是创建的新对象
        Book book31 = (Book) context.getBean("book3");
        Book book32 = (Book) context.getBean("book3");
        System.out.println(book31);
        System.out.println(book32);
        System.out.println(book31==book32);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        //book4指定了init()方法和destroy()方法
        Book book4 = (Book) context.getBean("book4");
        System.out.println(book4);

    }
}
