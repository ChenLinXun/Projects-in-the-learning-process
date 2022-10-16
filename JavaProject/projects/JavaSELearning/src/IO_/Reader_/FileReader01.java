package IO_.Reader_;
import org.junit.jupiter.api.Test;
import java.io.FileReader;
import java.io.IOException;
/*
 * FileReader：
 * 构造方法:
 * new FileReader(File/String)
 *
 * 读取方式:
 * 1.  read()：每次读取单个字符，返回该字符，如果到文件末尾返回-1
 * 2.  read(char[])：批量读取多个字符到数组，返回读取到的字符数，如果到文件末尾返回-1 
 *     相关API: 
 *     1）new String(char)：将char[]转换成String 
 *     2）String(char[], off, len)：将char[]的指定部分转换成String
 */
@SuppressWarnings({"all"})
public class FileReader01 {

    public static void main(String[] args) {
        System.out.println("FileReader的读取方式...");
    }

    @Test
    public void read01(){

        String path = "src\\IO_\\z_Resource\\登幽州台歌";

        FileReader fr = null;

        try {
            fr = new FileReader(path);

            //调用read()方法读取，每次读取一个字符，并返回
            //读取完毕，返回-1
            int data = 0;//读取的字符
            while ((data = fr.read()) != -1){
                System.out.print((char)data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void read02(){

        String path = "src\\IO_\\z_Resource\\登幽州台歌";

        FileReader fr = null;

        try {
            fr = new FileReader(path);

            //read(char[] buff)方法，一次读取一个字节数组，读到该数组中
            //正常读取，返回实际读到的字节数
            //读取完毕，返回-1
            int readLen = 0;//读取的字符个数
            char[] buff = new char[8];
            while ((readLen = fr.read(buff)) != -1){
                System.out.print(new String(buff,0,readLen));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
