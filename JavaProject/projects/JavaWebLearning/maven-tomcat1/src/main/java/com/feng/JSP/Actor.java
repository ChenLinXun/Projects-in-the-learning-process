package com.feng.JSP;

public class Actor {

    private String name;
    private String sex;
    private String breath;
    private String level;
    private int survive;

    public Actor(String name, String sex, String breath, String level, int survive) {
        this.name = name;
        this.sex = sex;
        this.breath = breath;
        this.level = level;
        this.survive = survive;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getBreath() {
        return breath;
    }

    public String getLevel() {
        return level;
    }

    public int getSurvive() {
        return survive;
    }
}
