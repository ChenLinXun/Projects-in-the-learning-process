package com.feng.JDK_DynamicProxy.dao;

public class StudentDaoImpl implements StudentDao{
    @Override
    public void insert() {
        System.out.println("~~~~~~insert~~~student~~~~~~");
    }

    @Override
    public void update() {
        System.out.println("~~~~~~update~~~student~~~~~~");
    }

    @Override
    public void delete() {
        System.out.println("~~~~~~delete~~~student~~~~~~");
    }
}
