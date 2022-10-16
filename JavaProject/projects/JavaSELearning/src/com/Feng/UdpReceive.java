package com.Feng;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceive {
    public static void main(String[] args) throws Exception{//暂时先不处理异常
        //开放端口
        DatagramSocket socket = new DatagramSocket(9999);

        while (true) {
            //接受数据包
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
            socket.receive(packet);//阻塞式接受包裹

            byte[] data = packet.getData();
            String str = new String(data,0,data.length);

            //将数据打印出来
            System.out.println(str);

            if(data.equals("88")){
                break;
            }
        }

        //关闭连接
        socket.close();
    }
}
