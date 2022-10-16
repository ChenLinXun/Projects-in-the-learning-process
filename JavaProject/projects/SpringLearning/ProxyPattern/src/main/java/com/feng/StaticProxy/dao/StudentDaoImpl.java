package com.feng.StaticProxy.dao;

public class StudentDaoImpl implements GeneraDao{
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
