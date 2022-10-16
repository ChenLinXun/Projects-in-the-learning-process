package com.Feng;

import java.io.*;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IOtest {
    public static void main(String[] args) throws Exception {
        //先读进来
        FileInputStream fileInputStream = new FileInputStream("D:/学习/java学习笔记/JavaSE基础/IO流.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("D:/学习/java学习笔记/JavaSE基础/IO流2.txt");
        //一边读一边写
        byte[] bytes = new byte[4];
        int readCount = 0;
        while ((readCount = fileInputStream.read(bytes)) != -1){
            fileOutputStream.write(bytes,0,readCount);
        }



        //刷新和关闭
        fileInputStream.close();
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}

