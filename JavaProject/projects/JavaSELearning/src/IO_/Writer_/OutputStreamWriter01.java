package IO_.Writer_;
import java.io.*;
/*
 * 使用转换流进行写文件，可以根据指定的编码方式写入
 */
public class OutputStreamWriter01 {

    public static void main(String[] args) {

        String path = "src\\IO_\\z_Resource\\GBK文本文档.txt";

        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path),"gbk"));

            bw.write("这是一个gbk编码的文档");
            bw.newLine();
            bw.write("你好，我叫陈林迅");

        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            if(bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
