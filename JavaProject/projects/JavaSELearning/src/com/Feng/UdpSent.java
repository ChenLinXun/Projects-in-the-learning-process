package com.Feng;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpSent {
    public static void main(String[] args) throws Exception {//暂时先不处理异常
        //建立一个socket
        DatagramSocket socket = new DatagramSocket();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            //搞个包出来
            String str = reader.readLine();
            byte[] bytes = str.getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getLocalHost(), 9999);
            //发送
            socket.send(packet);
            if(str.equals("88")){
                break;
            }
        }
        //关闭流
        socket.close();
    }
}
