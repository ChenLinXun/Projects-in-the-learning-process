package IO_.Reader_;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/*
 * BufferedReader：
 * 构造方法:
 * 传入字符输入流类型的节点流：BufferedReader(Reader in)
 *
 * 常用方法:
 * 1.  readLine() ：读一行文本
 * 2.  skip()：跳过n个字符再继续读取
 */
public class BufferedReader01 {

    public static void main(String[] args) throws IOException {

        String path = "src\\IO_\\z_Resource\\登幽州台歌";

        BufferedReader bfr = new BufferedReader(new FileReader(path));

        //按行读取，效率更高
        String readLine;
        while ((readLine = bfr.readLine()) != null){
            System.out.println(readLine);
        }

        //关闭处理流，底层会自动关闭节点流
        bfr.close();
    }

}
