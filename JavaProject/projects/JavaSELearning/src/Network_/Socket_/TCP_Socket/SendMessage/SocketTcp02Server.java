package Network_.Socket_.TCP_Socket.SendMessage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/*
 * 字符流完成客户端-服务端的通信
 */
public class SocketTcp02Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);

        System.out.println("服务端在9999端口监听...");
        Socket socket = serverSocket.accept();

        //收取客户端的消息：
        InputStream inputStream = socket.getInputStream();

        //通过转换流将字节流转换为字符缓冲流
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        //使用字符输入流读取客户端消息
        System.out.println("来自客户端的消息：");
        String readLine;
        while ((readLine = br.readLine()) != null){
            System.out.println(readLine);
        }

        //-------------------------------------------------------------------------

        //向客户端发送消息：
        OutputStream outputStream = socket.getOutputStream();

        //通过转换流将字节流转换为字符缓冲流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        //使用字符输出流向客户端发送消息
        bw.write("客户端，你好！");
        //使用字符流，发送结束后一定要刷新flush()
        bw.flush();
        //注意！消息发送完毕后，一定要设置结束标记，否则对方无法识别发送结束，导致阻塞
        socket.shutdownOutput();

        System.out.println("服务端退出...");

        //关闭资源，后打开的先关闭
        br.close();
        bw.close();
        serverSocket.close();
        socket.close();

    }

}
