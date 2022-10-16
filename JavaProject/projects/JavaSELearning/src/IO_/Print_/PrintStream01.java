package IO_.Print_;
import java.io.FileNotFoundException;
import java.io.PrintStream;
/*
 * 1.  打印流只有输出流，字节打印流和字符打印流；
 * 2.  PrintStream是基类InputStream的实现子类， 
 *     PrintWriter是基类Writer的实现子类；
 * 3.  PrintStream不需要手动关闭，PrintWriter需要
 * 4.  System类中的输入输出流被称为标准输入输出   
 *     而其输出流就是PintStream，字节打印流 
 *     其输入流是BufferedInputStream，字节缓冲流
 */
public class PrintStream01 {

    public static void main(String[] args) throws FileNotFoundException {

        //默认情况下，System中的PrintStream流out打印信息到屏幕上
        /*
           public void print(String s) {
                if (s == null) {
                    s = "null";
                }
                write(s);
            }
         */
        System.out.println("原来默认的标准输出，输出到控制台");
        //相当于：
        PrintStream ps = System.out;
        ps.println("就像这样...");

        //打印流一般在System类中使用，可以改变System中的PrintStream流out的输出方向，
        //使得System.out.println();直接将内容输出到指定日志文件

        //使用Log类进行日志打印（Log类中将标准输出流向进行了改变）
        Log.log("陈林迅完成订单0103...");

        System.out.println("使用了日志类，不会改变当前标准输出流的流向...");

    }

}
