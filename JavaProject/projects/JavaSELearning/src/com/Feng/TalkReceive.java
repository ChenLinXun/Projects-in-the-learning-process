package com.Feng;

import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class TalkReceive implements Runnable {

    DatagramSocket socket = null;
    private int port;
    private String msgFrom;

    public TalkReceive(int port,String msgFrom) {
        this.port = port;
        this.msgFrom = msgFrom;
        try{
            socket = new DatagramSocket(port);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                //接受数据包
                byte[] bytes = new byte[1024];
                DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
                socket.receive(packet);//阻塞式接受包裹

                byte[] data = packet.getData();
                String str = new String(data,0,data.length);

                //将数据打印出来
                System.out.println(msgFrom + ":" +str);

                if(data.equals("88")){
                    break;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        //关闭连接
        socket.close();
    }
}
