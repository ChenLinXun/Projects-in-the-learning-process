package com.feng.test;

import com.feng.dao.BookDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test02 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        BookDao bookDao = (BookDao) context.getBean("bookDao");
        bookDao.insert();

    }
}
