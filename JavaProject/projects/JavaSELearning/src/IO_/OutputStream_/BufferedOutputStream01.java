package IO_.OutputStream_;
import java.io.*;
/*
 * BufferedOutputStream:
 * 构造方法：
 * 传入字节输出流类型的节点流：BufferedOutputStream(OutputStream out)
 *
 * 常用方法：一般直接用所包装的节点流的方法
 */
public class BufferedOutputStream01 {

        public static void main(String[] args) throws IOException {

        String path = "src\\IO_\\z_Resource\\hello.txt";

        BufferedOutputStream bfi = new BufferedOutputStream(new FileOutputStream(path));

        bfi.write("hello,world!".getBytes());

        bfi.close();

    }

}
