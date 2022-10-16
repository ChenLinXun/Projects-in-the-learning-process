package com.feng.ioc.bean;

import java.util.Date;

public class Actor {

    private String name;
    private String sex;
    private String skill;
    private String level;
    private Date date;
    private Teacher teacher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", skill='" + skill + '\'' +
                ", level='" + level + '\'' +
                ", date=" + date +
                ", teacher=" + teacher +
                '}';
    }
}
