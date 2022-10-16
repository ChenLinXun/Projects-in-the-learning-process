package com.Feng;

import java.io.Serializable;

public class User implements Serializable {
    private int no;
    private transient String name;
    //手动写入一个序列化版本号，以便该类后续修改后仍能反序列化之前序列化过的信息
    private static final long serialVersionUID = 2657434992L;

    public User() {
    }

    public User(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
