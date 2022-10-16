package Network_.Socket_.UDP_Socket;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/*
 * 在UDP协议下主机A、B互发数据，A先接收，所以先启动A
 */
public class SocketUdp01HostB {

    public static void main(String[] args) throws IOException {

        //准备在9998端口接收数据，同一台主机，要和SocketUdp01HostA区分开
        DatagramSocket socket = new DatagramSocket(9998);

        //---------------------发包------------------------------//

        //创建一个DatagramPacket对象，准备发送数据包
        //每个数据包的大小限制在64K内
        byte[] buff = "hello，明天吃火锅".getBytes();
        //装包，标明数据包发送地址：SocketUdp01HostA的ip地址和端口
        DatagramPacket packet =
                new DatagramPacket(buff, buff.length, InetAddress.getLocalHost(),9999);

        //发包
        socket.send(packet);
        System.out.println("HostB发送了一个数据包");

        //---------------------收包------------------------------//

        byte[] buff2 = new byte[1024*64];
        DatagramPacket packet2 = new DatagramPacket(buff2, buff2.length);

        System.out.println("HostB正在等待接收数据...");
        socket.receive(packet2);

        //拆包，将数据展示出来
        System.out.println("HostB接收了一个数据包：");
        int length = packet2.getLength();//数据包中的数据长度
        byte[] data = packet2.getData();//整个数据包（字节数组）
        System.out.println("来自HostA的数据："+new String(data,0,length));

        //关闭资源
        socket.close();
        System.out.println("HostB退出...");

    }

}
