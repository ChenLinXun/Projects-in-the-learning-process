package IO_.Print_;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/*
 * 1.  打印流只有输出流，字节打印流和字符打印流；
 * 2.  PrintStream是基类InputStream的实现子类， 
 *     PrintWriter是基类Writer的实现子类；
 * 3.  PrintStream不需要手动关闭，PrintWriter需要
 * 4.  System类中的输入输出流被称为标准输入输出   
 *     而其输出流就是PintStream，字节打印流 
 *     其输入流是BufferedInputStream，字节缓冲流
 */
public class PrintWriter01 {

    public static void main(String[] args) throws IOException {

        //这样构造相当于在控制台中输出，包装的是PrintStream流：System.out
        PrintWriter pw1 = new PrintWriter(System.out);
        pw1.println("你好，我叫陈林迅");
        //PrintWriter必须手动关闭
        pw1.close();

        //这样构造则是输出到文件中，需要手动关闭
        String path = "src\\IO_\\z_Resource\\哈喽.txt";
        PrintWriter pw2 = new PrintWriter(new FileWriter(path,true));
        //输出
        pw2.println();
        pw2.print("这一行是PrintWriter输出的...");
        //PrintWriter必须手动关闭
        pw2.close();

    }

}
