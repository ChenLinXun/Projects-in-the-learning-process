package com.feng.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransactionManager {

    //定义切入点
    @Pointcut("execution(* com.feng.dao.*.*(..))")
    public void pc1(){}

    //定义切点方法：
    //前置通知
    @Before("execution(* com.feng.dao.*.*(..))")
    public void begin(){
        System.out.println("开启事务...");
    }

    //后置通知
    @After("pc1()")
    public void commit(){
        System.out.println("提交事务...");
    }

    @Around("pc1()")
    public Object printExecuteTime(ProceedingJoinPoint point) throws Throwable {
        long time1 = System.currentTimeMillis();
        Object v = point.proceed();
        long time2 = System.currentTimeMillis();
        System.out.println("time："+(time2-time1)+"ms");
        return v;
    }

}
