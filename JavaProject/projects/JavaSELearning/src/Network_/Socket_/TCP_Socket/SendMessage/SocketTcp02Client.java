package Network_.Socket_.TCP_Socket.SendMessage;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
/*
 * 字符流完成客户端-服务端的通信
 */
public class SocketTcp02Client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        //向服务端发送消息
        OutputStream outputStream = socket.getOutputStream();

        //通过转换流将字节流转换为字符缓冲流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        //使用字符输出流向服务端发送消息
        bw.write("服务端，你好！");
        //使用字符流，发送结束后一定要刷新flush()
        bw.flush();
        //注意！消息发送完毕后，一定要设置结束标记，否则对方无法识别发送结束，导致阻塞
        socket.shutdownOutput();

        //-------------------------------------------------------------------------

        //接受服务端的消息
        InputStream inputStream = socket.getInputStream();

        //通过转换流将字节流转换为字符缓冲流
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        //使用字符输入流读取服务端消息
        System.out.println("来自服务端的消息：");
        String readLine;
        while ((readLine = br.readLine()) != null){
            System.out.println(readLine);
        }

        System.out.println("客户端退出...");

        //关闭资源，后打开的先关闭
        br.close();
        bw.close();
        socket.close();

    }

}
