package com.Feng;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class TcpServer {
    public static void main(String[] args) {
        ServerSocket serverSocket =null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try {
            //1.创建一个端口号
            serverSocket = new ServerSocket(9999);

            //2.等待客户端连接过来
            socket = serverSocket.accept();
            //3.读取客户端消息
            is = socket.getInputStream();

            //管道流
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while((len = is.read(buffer)) != -1){
                baos.write(buffer,0,len);
            }

            System.out.println(baos.toString());

        } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (baos != null) {
                    try {
                        baos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (serverSocket != null) {
                        try {
                            serverSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        }
    }
}
