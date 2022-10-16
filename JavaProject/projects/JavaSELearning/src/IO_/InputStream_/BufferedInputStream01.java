package IO_.InputStream_;
import java.io.*;
/*
 * BufferedInputStream:
 * 构造方法：
 * 传入字节输入流类型的节点流：BufferedInputStream(InputStream in)
 *
 * 常用方法：一般直接用所包装的节点流的方法
 */
public class BufferedInputStream01 {

    public static void main(String[] args) throws IOException {

        String path = "src\\IO_\\z_Resource\\hello.txt";

        BufferedInputStream bfi = new BufferedInputStream(new FileInputStream(path));

        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = bfi.read(buf)) != -1){
            System.out.println(new String(buf,0,readLen));
        }

        bfi.close();
    }

}
