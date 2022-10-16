package Network_.Socket_.TCP_Socket.SendMessage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
/*
 * 字节流完成客户端-服务端的通信
 */
public class SocketTcp01Client {

    public static void main(String[] args) throws IOException {

        //根据服务端ip地址和端口号，创建socket对象（连接），连接到客户端端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        //根据此socket对象（连接）创建字节输出流，向客户端发送消息
        //这里是向上转型
        OutputStream outputStream = socket.getOutputStream();

        //该outputStream流实际类型是：java.net.SocketOutputStream
        //System.out.println(outputStream.getClass());

        //发送消息
        outputStream.write("Hello，server ~~~".getBytes());
        System.out.println("向服务端发送了一条消息...");

        //注意！发送消息结束后，要设置发送结束标记，否则对方无法识别是否还要继续接受，导致阻塞
        socket.shutdownOutput();

        //----------------------------------------------------------------

        //获取字节输入流获取服务端消息
        //仍然是向上转型
        InputStream inputStream = socket.getInputStream();

        System.out.println("收到服务端的消息：");
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1){
            System.out.println(new String(buf,0,readLen));
        }

        System.out.println("客户端退出...");

        //关闭资源：Socket连接、io流，后打开的先关闭
        outputStream.close();
        inputStream.close();
        socket.close();

    }

}
