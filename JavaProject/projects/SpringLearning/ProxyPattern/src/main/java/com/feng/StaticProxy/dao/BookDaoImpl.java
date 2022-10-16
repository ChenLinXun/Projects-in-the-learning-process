package com.feng.StaticProxy.dao;

public class BookDaoImpl implements GeneraDao{
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
