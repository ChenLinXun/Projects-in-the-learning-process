package Network_.Socket_.TCP_Socket.FileUpload;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
/*
 * 使用字节流和字符流，完成客户端文件上传
 */
public class SocketFileUploadClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        //------------------发送------------------------------------------//

        //数据通道，输出流
        OutputStream outputStream = socket.getOutputStream();

        //先发送一句话，告诉服务端要上传文件，使用字符流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("服务端你好，我现在要上传一张图片");
        //另起一行，以免部分图片的数据和这一句话在同一行而被接收，导致图片数据损失
        bw.newLine();
        //注意！使用字符流要flush()
        bw.flush();

        //开始发送图片，使用字节流
        String path = "src\\Network_\\Socket_\\TCP_Socket\\FileUpload\\ClientRecourse\\看书女孩.jpg";
        //一边从资源目录中读取，一边上传到客户端
        FileInputStream fi = new FileInputStream(path);
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = fi.read(buf)) != -1){
            outputStream.write(buf,0,readLen);
        }

        //注意！上传结束要设置结束标志！
        socket.shutdownOutput();

        //--------------------接收------------------------------------------//

        //接收客户端的上传成功回复
        //数据通道，输入流
        InputStream inputStream = socket.getInputStream();

        //使用字符流接收回复
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println("来自服务端："+br.readLine());

        System.out.println("客户端退出...");

        //关闭资源
        br.close();
        fi.close();
        bw.close();

    }

}
