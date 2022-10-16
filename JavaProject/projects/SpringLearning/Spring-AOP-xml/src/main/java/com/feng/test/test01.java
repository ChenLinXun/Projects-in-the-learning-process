package com.feng.test;

import com.feng.dao.BookDao;
import com.feng.dao.StudentDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test01 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //要使用aop面向切面编程，调用切入点方法的对象必须通过Spring容器获取，不能使用关键字new
        BookDao bookDao = (BookDao) context.getBean("bookDao");
        bookDao.update();

        StudentDao studentDao = (StudentDao) context.getBean("studentDao");
        studentDao.delete();
    }
}
