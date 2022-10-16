package IO_.Standard;
import java.util.Scanner;
/*
 *   标准输入输出流（System类的输入输出）
 */
public class System_ {

    public static void main(String[] args) {

        //System类中属性：public final static InputStream in = null;
        //System.in 的编译类型：InputStream
        //System.in 的运行类型：BufferedInputStream
        //表示的是，标准输入： 键盘
        System.out.println("运行类型："+System.in.getClass());


        //System类中属性：public final static PrintStream out = null;
        //System.out 的编译类型：PrintStream
        //System.out 的运行类型：PrintStream
        //表示的是，标准输出： 显示器
        //PrintStream中的println()方法将信息打印到显示器
        System.out.println("运行类型："+System.out.getClass());


        //Scanner是从标准输入：键盘 中接受数据
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        String next = scanner.next();
        System.out.println(next);

    }

}
