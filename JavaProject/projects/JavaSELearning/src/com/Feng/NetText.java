package com.Feng;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetText {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress1 = InetAddress.getByName("10.205.16.23");
            System.out.println(inetAddress1.getHostName());
            Logger.log("查询了IP地址为10.130.0.23的主机，并返回了其主机名");
            InetAddress inetAddress2 = InetAddress.getByName("www.bilibili.com");
            System.out.println(inetAddress2.getHostAddress());
            Logger.log("查询了bilibili网站的IP地址，并将其返回");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println();



    }
}