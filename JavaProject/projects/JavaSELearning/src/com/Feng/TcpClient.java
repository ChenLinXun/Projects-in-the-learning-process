package com.Feng;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
    public static void main(String[] args)  {
        //1.要知道服务器地址和端口号
        InetAddress serverIP = null;
        Socket socket = null;
        OutputStream os = null;
        try {
            serverIP = InetAddress.getByName("127.0.0.1");

            int port = 9999;
            //2.创建一个socket连接
            socket = new Socket(serverIP,port);
            //发送消息 IO流
            os = socket.getOutputStream();
            os.write("考试是真滴烦".getBytes());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
