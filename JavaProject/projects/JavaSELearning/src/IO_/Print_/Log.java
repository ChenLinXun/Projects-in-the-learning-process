package IO_.Print_;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 *  利用PrintStream做一个日志打印工具
 */
public class Log {

    public static void log(String msg){

        //备份原来System标准输出（到控制台），否则改不回去了！
        PrintStream BeforePs = System.out;

        //指向日志保存文件的打印流
        String path = "src\\IO_\\z_Resource\\标准输出（日志文件）.txt";
        PrintStream NowPs = null;

        try {
            //更改后的标准输出流，对节点流FileOutputStream进行包装，可以实现追加方式记录日志
            NowPs = new PrintStream(new FileOutputStream(path,true));
            //更改标准输出方向
            System.setOut(NowPs);

            //获取当前时间 日期
            Date nowTime = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
            String strTime = sdf.format(nowTime);

            //将日志内容打印至日志文件
            System.out.println(strTime + ":" + msg);

            //最后将标准输出方向改回
            System.setOut(BeforePs);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }//打印流不需要手动关闭
    }

}
