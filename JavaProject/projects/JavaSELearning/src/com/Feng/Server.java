package com.Feng;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws Exception {//暂时不处理异常
        //创建连接
        ServerSocket serversocket = new ServerSocket(9999);
        Socket socket = serversocket.accept();//客户端接入前此处会阻塞

        //接受信息
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        System.out.println(dis.readUTF());

        //接受图片并存入硬盘
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("收到的图片.jpg");
        byte[] bytes = new byte[1024];
        int len;
        while ((len = is.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }

        //确定已经接受
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF("服务器：我已成功接收");

        //关闭资源
        is.close();
        fos.close();
        socket.close();
        serversocket.close();
    }
}
