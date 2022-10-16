package com.feng.StaticProxy.test;

import com.feng.StaticProxy.dao.BookDaoImpl;
import com.feng.StaticProxy.dao.MyStaticProxy;
import com.feng.StaticProxy.dao.StudentDaoImpl;

public class StaticProxyTest {

    public static void main(String[] args) {

        MyStaticProxy proxy1 = new MyStaticProxy(new BookDaoImpl());
        proxy1.insert();

        MyStaticProxy proxy2 = new MyStaticProxy(new StudentDaoImpl());
        proxy2.insert();

    }
}
