package com.feng.JDK_DynamicProxy.dao;

public class BookDaoImpl implements BookDao{
    @Override
    public void insert() {
        System.out.println("~~~~~~insert~~~book~~~~~~");
    }

    @Override
    public void update() {
        System.out.println("~~~~~~update~~~book~~~~~~");
    }

    @Override
    public void delete() {
        System.out.println("~~~~~~delete~~~book~~~~~~");
    }
}
