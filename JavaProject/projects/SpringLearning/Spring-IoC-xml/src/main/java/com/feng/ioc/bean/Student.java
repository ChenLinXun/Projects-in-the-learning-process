package com.feng.ioc.bean;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class Student {

    private String stuNum;
    private String stuName;
    private String stuGender;
    private int stuAge;
    private double weight;
    private Date enterTime;
    private Clazz clazz;

    public Student(){

    }

    public Student(String stuNum, String stuName, String stuGender, int stuAge, double weight, Date enterTime, Clazz clazz) {
        this.stuNum = stuNum;
        this.stuName = stuName;
        this.stuGender = stuGender;
        this.stuAge = stuAge;
        this.weight = weight;
        this.enterTime = enterTime;
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNum='" + stuNum + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuGender='" + stuGender + '\'' +
                ", stuAge=" + stuAge +
                ", weight=" + weight +
                ", enterTime=" + enterTime +
                ", clazz=" + clazz +
                '}';
    }
}
