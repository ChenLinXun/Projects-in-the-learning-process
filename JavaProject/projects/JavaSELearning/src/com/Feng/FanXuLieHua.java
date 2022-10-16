package com.Feng;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class FanXuLieHua {
    public static void main(String[] args) throws Exception {//暂时先不管异常
        //反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("users"));
        //最好这样改成这样写
        List<User> userList1 = (List<User>) ois.readObject();
        for (User user : userList1) {
            System.out.println(user);
        }
        //关闭
        ois.close();
    }
}
