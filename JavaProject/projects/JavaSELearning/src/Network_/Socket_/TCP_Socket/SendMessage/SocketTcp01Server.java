package Network_.Socket_.TCP_Socket.SendMessage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/*
 * 字节流完成客户端-服务端的通信
 */
public class SocketTcp01Server {

    public static void main(String[] args) throws IOException {

        //创建ServerSocket对象，监听窗口，等待Socket连接
        ServerSocket serverSocket = new ServerSocket(9999);

        //通过ServerSocket对象的accept()获取Socket对象（Socket连接）
        //此处阻塞等待连接
        System.out.println("服务端正在9999端口监听.....");
        Socket socket = serverSocket.accept();

        //根据获取的socket对象（连接）创建字节输入流，收取客户端消息
        //这里是向上转型
        InputStream inputStream = socket.getInputStream();

        //该InputStream对象实际类型是：java.net.SocketInputStream
        //System.out.println(inputStream.getClass());

        System.out.println("服务端收到客户端消息：");
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1){
            System.out.println(new String(buf,0,readLen));
        }

        //-----------------------------------------------------------

        //收到消息后，向客户端回送消息
        //获取字节输出流，仍是向上转型
        System.out.println("服务端向客户端发送了一条消息...");
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello，client ~~~".getBytes());

        //注意！发送消息结束后，要设置发送结束标记，否则对方无法识别是否还要继续接受，导致阻塞
        socket.shutdownOutput();

        System.out.println("服务端退出...");

        //关闭资源：ServerSocket连接、Socket连接、io流，后打开的先关闭
        inputStream.close();
        outputStream.close();
        serverSocket.close();
        socket.close();

    }

}
