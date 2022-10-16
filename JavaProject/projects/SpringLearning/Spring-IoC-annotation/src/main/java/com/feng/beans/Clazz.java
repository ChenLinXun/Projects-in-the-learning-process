package com.feng.beans;

import org.springframework.stereotype.Component;

@Component(value = "clz")
public class Clazz {

    private int clazzNum;

    public int getClazzNum() {
        return clazzNum;
    }

    public void setClazzNum(int clazzNum) {
        this.clazzNum = clazzNum;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "clazzNum=" + clazzNum +
                '}';
    }
}
