package com.Feng;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {//暂时不处理异常
        //建立连接
        InetAddress serverIP = InetAddress.getLocalHost();
        int port = 9999;
        Socket socket = new Socket(serverIP,port);
        //通知服务器要发送一张图片过去
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF("我要发一张图片给你，请接收");
        //从硬盘中获取一张图片并发送出去
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream("D:\\360安全浏览器下载\\看书女孩.jpg");
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1){
            os.write(bytes,0,len);
        }

        //通知服务器已经输出完毕
        socket.shutdownOutput();
        //确定服务器接受完毕后关闭
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        System.out.println(dis.readUTF());

        //关闭资源
        os.close();
        fis.close();
        socket.close();
    }
}
