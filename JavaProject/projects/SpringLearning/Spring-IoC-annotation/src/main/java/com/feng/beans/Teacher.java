package com.feng.beans;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component(value = "teacher")
public class Teacher {

    private String teacherNum;
    private String teacherName;
    private String teacherGender = "女";
    private int teacherAge;
    private double weight;
    private Date enterTime;

    @Resource
    private Clazz clazz;

    public String getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(String teacherNum) {
        this.teacherNum = teacherNum;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherGender() {
        return teacherGender;
    }

    public void setTeacherGender(String teacherGender) {
        this.teacherGender = teacherGender;
    }

    public int getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(int teacherAge) {
        this.teacherAge = teacherAge;
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

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherNum='" + teacherNum + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherGender='" + teacherGender + '\'' +
                ", teacherAge=" + teacherAge +
                ", weight=" + weight +
                ", enterTime=" + enterTime +
                ", clazz=" + clazz +
                '}';
    }
}
