package IO_.Writer_;
import java.io.FileWriter;
import java.io.IOException;
/*
 * FileWriter：
 * 构造方法:
 * 1) new FileWriter(File/String)：覆盖模式，相当于流的指针在首端
 * 2) new FileWriter(File/String,true)：追加模式,相当于流的指针在尾端
 *
 * 读取方式:
 * 1) write(int)：写入单个字符
 * 2) write(char[])：写入指定数组
 * 3) write(char[],off,len)：写入指定数组的指定部分
 * 4) write (string)：写入整个字符串
 * 5) write(string,off,len)：写入字符串的指定部分
 *
 * 相关API:
 * String类：toCharArray:将String转换成char[]
 * 注意:
 * FileWriter使用后，必须要关闭(close)或刷新(flush)，否则写入不到指定的文件!
 * 原因：调用close或flush方法，底层才执行真正将数据写入磁盘的操作
 */
public class FileWriter01 {

    public static void main(String[] args) {
        System.out.println("FileWriter的写入方式...");

        String path = "src\\IO_\\z_Resource\\哈喽.txt";

        FileWriter fw = null;

        try {
            fw = new FileWriter(path);

            //写入单个字符：write(int c)
            fw.write('H');

            //写入指定数组：write(char c[])
            char[] s = {'e','l','l','o',','};
            fw.write(s);

            //写入指定数组的指定部分：
            fw.write("world!World".toCharArray(),0,6);

            //写入字符串：write(String str)
            String str = "你好，";
            fw.write(str);

            //写入指定字符串的指定部分
            fw.write("世界！哈哈哈",0,3);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}