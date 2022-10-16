package Network_.Socket_.UDP_Socket;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/*
 * 在UDP协议下主机A、B互发数据，A先接收，所以先启动A
 */
public class SocketUdp01HostA {

    public static void main(String[] args) throws IOException {

        //创建一个DatagramSocket对象，准备在9999端口接收数据，要和SocketUdp01HostB区分开
        DatagramSocket socket = new DatagramSocket(9999);

        //---------------------收包------------------------------//

        //创建一个DatagramPacket对象，准备收取数据包
        //每个数据包的大小限制在64K内
        byte[] buff = new byte[1024*64];
        DatagramPacket packet = new DatagramPacket(buff, buff.length);

        //调用DatagramSocket对象的接收方法receive()，收取一个数据包，装包
        //此处会阻塞等待数据发送过来
        System.out.println("HostA正在等待接收数据...");
        socket.receive(packet);

        //拆包，将数据展示出来
        System.out.println("HostA接收了一个数据包：");
        int length = packet.getLength();//数据包中的数据长度
        byte[] data = packet.getData();//整个数据包（字节数组）
        System.out.println("来自HostB的数据："+new String(data,0,length));

        //---------------------发包------------------------------//
        //创建一个DatagramPacket对象，准备发送数据包
        //每个数据报的大小限制在64K内
        byte[] buff2 = "ok，明天见".getBytes();
        //装包，标明数据包发送地址：SocketUdp01HostB的ip地址和端口
        DatagramPacket packet2 =
                new DatagramPacket(buff2, buff2.length, InetAddress.getLocalHost(),9998);

        //发包
        socket.send(packet2);
        System.out.println("HostA发送了一个数据包");

        //关闭资源
        socket.close();
        System.out.println("HostA退出");
    }

}
