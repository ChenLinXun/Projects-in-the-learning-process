package com.Feng;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
//日志工具类
public class Logger {
    //记录日志的方法
    public static void log(String msg) {
        try{
            //新建一个打印对象指向一个日志
            PrintStream out = new PrintStream(new FileOutputStream("网络执行日志.txt",true));
            //将先前的标准输出指向（即指向控制台的这个方向）进行保存
            PrintStream beforePrintStream = System.out;
            //改变输出方向
            System.setOut(out);
            //日期当前时间
            Date nowTime = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
            String strTime = sdf.format(nowTime);
            //将日志内容打印至日志文件
            System.out.println(strTime + ":" + msg);
            //将标准输出指向重新改回，指向控制台，使标准输出仅在记录日志时指向日志文件
            System.setOut(beforePrintStream);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
