package com.feng.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;

@Component(value = "stu")
@Scope("singleton")
@Lazy(true)
public class Student {

    private String stuNum;
    private String stuName;
    private String stuGender = "女";
    private int stuAge;
    private double weight;
    private Date enterTime;
    private Clazz clazz;

    public Student(){
        System.out.println("student创建了......");
    }

    @PostConstruct
    public void init(){
        System.out.println("init......");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy......");
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public Clazz getClazz() {
        return clazz;
    }

    @Autowired
    public void setClazz(@Qualifier("clz") Clazz clazz) {
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

