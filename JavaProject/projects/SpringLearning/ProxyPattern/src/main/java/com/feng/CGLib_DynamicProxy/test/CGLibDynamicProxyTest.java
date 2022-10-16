package com.feng.CGLib_DynamicProxy.test;

import com.feng.CGLib_DynamicProxy.dao.BookDao;
import com.feng.CGLib_DynamicProxy.dao.CGLibDynamicProxy;
import com.feng.CGLib_DynamicProxy.dao.StudentDao;

public class CGLibDynamicProxyTest {
    public static void main(String[] args) {

        //创建被代理对象
        StudentDao studentDao = new StudentDao();
        BookDao bookDao = new BookDao();

        //通过cglib动态代理类创建代理对象
        CGLibDynamicProxy cgLibDynamicProxy1 = new CGLibDynamicProxy(studentDao);
        //代理对象实际上是被代理对象的子类对象，因此代理对象可直接强转为被代理类型
        StudentDao proxy1 = (StudentDao) cgLibDynamicProxy1.getProxy();
        //使用对象调用方法，实际上并没有执行这个方法，而是执行了代理类中的intercept方法，
        //将当前调用的方法以及方法中的参数传递到intercept方法中
        proxy1.insert();

        CGLibDynamicProxy cgLibDynamicProxy2 = new CGLibDynamicProxy(bookDao);
        BookDao proxy2 = (BookDao) cgLibDynamicProxy2.getProxy();
        proxy2.delete();

    }
}
