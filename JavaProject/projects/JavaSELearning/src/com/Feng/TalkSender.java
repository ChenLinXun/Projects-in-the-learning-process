package com.Feng;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PipedReader;
import java.net.*;

public class TalkSender implements Runnable{

    DatagramSocket socket = null;
    BufferedReader reader = null;

    private int fromPort;
    private String toIp;
    private int toPort;

    public TalkSender(int fromPort, String toIp, int toPort) {
        this.fromPort = fromPort;
        this.toIp = toIp;
        this.toPort = toPort;

        try{
            socket = new DatagramSocket(fromPort);
            reader = new BufferedReader(new InputStreamReader(System.in));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        while (true) {
            try {
                String str = reader.readLine();
                byte[] bytes = str.getBytes();
                DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length,new InetSocketAddress(this.toIp,this.toPort));
                //发送
                socket.send(packet);
                if(str.equals("88")) {
                    break;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            //搞个包出来
        }
        //关闭流
        socket.close();
    }
}
