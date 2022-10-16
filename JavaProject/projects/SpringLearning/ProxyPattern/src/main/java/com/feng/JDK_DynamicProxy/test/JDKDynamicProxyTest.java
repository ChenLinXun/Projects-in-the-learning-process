package com.feng.JDK_DynamicProxy.test;

import com.feng.JDK_DynamicProxy.dao.*;

public class JDKDynamicProxyTest {
    public static void main(String[] args) {

        JDKDynamicProxy jdkDynamicProxy1 = new JDKDynamicProxy(new BookDaoImpl());
        BookDao proxy1 = (BookDao) jdkDynamicProxy1.getProxy();
        proxy1.insert();

        JDKDynamicProxy jdkDynamicProxy2 = new JDKDynamicProxy(new StudentDaoImpl());
        StudentDao proxy2 = (StudentDao) jdkDynamicProxy2.getProxy();
        proxy2.insert();

    }
}
