package IO_.Writer_;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/*
 * BufferedWriter：
 * 构造方法：
 * 传入字符输出流类型的节点流：BufferedWriter(Writer out)
 *
 * 常用方法：
 * 1.  newLine()：插入一个换行符
 * 2.  write(String str)：直接写入一行字符串
 */
public class BufferedWriter01 {

    public static void main(String[] args) throws IOException {

        String path = "src\\IO_\\z_Resource\\哈喽.txt";

        //追加写入数据
        BufferedWriter bfw = new BufferedWriter(new FileWriter(path,true));

        bfw.newLine();//插入一个换行符
        bfw.write("我叫陈林迅，");
        bfw.newLine();//插入一个换行符
        bfw.write("很高兴认识你");

        bfw.close();

    }

}
