package com.Feng;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class XuLieHua {public static void main(String[] args)throws Exception {//暂时先不管异常
    List<User> userList = new ArrayList<>();
    //参与序列化的ArrayList集合以及集合中的元素User都需要实现java.io.Serializable接口
    userList.add(new User(1,"zhangsan"));
    userList.add(new User(2,"lisi"));
    userList.add(new User(3,"wangwu"));
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("users"));

    //序列化一个集合，这个集合对象中放了很多其他对象
    oos.writeObject(userList);
    //刷新，关闭
    oos.flush();
    oos.close();
    }
}
