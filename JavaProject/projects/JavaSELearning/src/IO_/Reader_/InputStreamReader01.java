package IO_.Reader_;
import java.io.*;
/*
 * 转换流的引出:
 * 当我们使用字符流对文本文件进行读取的时候，默认是utf-8的编码方式读取，当读取的文件编码方式不符时，
 * 读取的中文等信息可能出现乱码问题，于是我们引出了转换流：
 * 用转换流可以指定编码方式，将传入的字节流转换为字符流，完成对文本的读取，有效解决中文乱码问题
 * 同时，使用转换流进行写文件，可以根据指定的编码方式写入
 *
 * InputStreamReader:
 * 构造方法:
 * 传入字节输入流和编码方式：InputStreamReader(InputStream in, String charsetName)
 * 使用方法:
 * 1.  传入字节输入流，构造一个字符转换流： 
 *     new InputStreamReader(new FileInputStream(path),"gbk");
 * 2.  将转换流包装成一个字符缓冲流： 
 *     br = new BufferedReader(isr);
 * 3.  使用字符缓冲流进行读取： 
 *     br.readLine()；
 */
public class InputStreamReader01 {

    public static void main(String[] args) {

        String path = "src\\IO_\\z_Resource\\乱码问题.txt";

        //使用传统方式（直接使用字符流读取），可能出现中文乱码问题
        oldWay();

        System.out.println("-------------使用转换流解决乱码问题------------------");
        //使用转换流，有效解决问题
        InputStreamReader isr = null;
        BufferedReader br = null;

        try {
            //将字节输入流转换为字符转换流（第一次包装）
            isr = new InputStreamReader(new FileInputStream(path),"gbk");

            //将转换流传入字符缓冲流，用字符缓冲流完成读取（第二次包装）
            br = new BufferedReader(isr);

            //开始读
            String data;
            while ((data = br.readLine()) != null){
                System.out.println(data);
            }

        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null) {
                try {
                    br.close();//关闭外层流
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void oldWay(){

        String path = "src\\IO_\\z_Resource\\乱码问题.txt";
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(path));
            String data;
            while ((data = br.readLine()) != null){
                System.out.println(data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
