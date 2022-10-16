package com.feng.StaticProxy.dao;

public class MyStaticProxy {

    private GeneraDao generaDao;

    public MyStaticProxy(GeneraDao generaDao){
        this.generaDao = generaDao;
    }

    public void insert() {
        begin();
        generaDao.insert();
        commit();
    }

    public void update() {
        begin();
        generaDao.update();
        commit();
    }

    public void delete() {
        begin();
        generaDao.delete();
        commit();
    }

    public void begin(){
        System.out.println("开启事务...");
    }

    public void commit(){
        System.out.println("提交事务...");
    }
}
