package Reflection.A_Example;
import java.io.*;
import java.lang.reflect.Method;
import java.util.Properties;
/*
 * 一个小例子引出反射：
 * 根据properties配置文件创建对象并调用其方法
 * 也就是修改配置文件中的键值，该程序会调用不同的方法
 */
public class reflection_example {

    public static void main(String[] args) throws IOException, ReflectiveOperationException {

        //读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\Reflection\\A_Example\\Dog"));

        //读取对应键值---全类名和方法
        String classFullName = properties.getProperty("ClassFullName");
        String methodName = properties.getProperty("MethodName");

        //加载类，返回Class类型的对象cls
        Class<?> cls = Class.forName(classFullName);

        //通过 cls 根据全类名获得该类对象：Reflection.A_Example.Dog
        Object o = cls.newInstance();

        //通过 cls 根据方法名获得该类对象的方法对象
        //即：在反射中，可以把一个方法视为一个对象（万物皆对象）
        Method method = cls.getMethod(methodName);

        //调用该方法对象的invoke（援引）方法，调用该类对象的方法
        method.invoke(o);
    }
}