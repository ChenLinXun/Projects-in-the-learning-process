package Network_.Socket_.TCP_Socket.FileUpload;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/*
 * 使用字节流和字符流，完成客户端文件上传
 */
public class SocketFileUploadServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8888);

        System.out.println("服务端在8888端口监听...");
        Socket socket = serverSocket.accept();

        //--------------------------接收------------------------------------//

        //接收客户端传来的消息，使用字符流接收
        InputStream inputStream = socket.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println("来自客户端："+br.readLine());

        //接收客户端上传的图片，并输出保存至客户端资源目录下
        String path = "src\\Network_\\Socket_\\TCP_Socket\\FileUpload\\ServerRecourse\\看书女孩.jpg";

        //开始接收图片，一边从客户端读取，一边输出到客户端资源目录下
        FileOutputStream fo = new FileOutputStream(path);
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1){
            fo.write(buf,0,readLen);
        }

        //--------------------------发送------------------------------------//

        //接收完毕后给客户端发送消息，回复上传成功，使用字符流
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("客户端你好，图片上传成功");
        //注意！使用字符流要flush()
        bw.flush();
        //注意！上传结束要设置结束标志！
        socket.shutdownOutput();

        System.out.println("服务端退出...");

        //关闭资源
        bw.close();
        fo.close();
        br.close();

    }

}
