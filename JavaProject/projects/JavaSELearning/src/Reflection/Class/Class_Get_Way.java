package Reflection.Class;
import Reflection.A_Example.Dog;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/*
 * 获取Class类对象的六种方法
 */
public class Class_Get_Way {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /*
           方法一：
           前提：已知一个类的全类名，且该类在类路径下，
           可通过Class类的静态方法Class.forName()获取
           应用场景：多用于配置文件，读取类全路径，加载类
         */
        //读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\Reflection\\A_Example\\Dog"));
        //读取对应键值---全类名和方法
        String classFullName = properties.getProperty("ClassFullName");
        //加载类，返回Class类型的对象cls
        Class<?> cls1 = Class.forName(classFullName);

        /*
           方法二：
           前提：已知具体的类，通过 类.class 获取，该方式最为安全可靠，程序性能最高
           应用场景：多用于参数传递，比如通过反射得到对应构造器对象
         */
        Class cls2 = Dog.class;

        /*
           方法三：
           已知某个类的实例，调用该实例的getClass()方法获取Class对象
           应用场景:通过创建好的对象，获取Class对象.
         */
        Dog dog = new Dog();
        Class cls3 = dog.getClass();

        /*
           方法四：
           其他方式：根据某个类的实例获取类加载器，通过类加载器获取Class对象
           ClassLoader cl =对象.getClass().getClassLoaderO;
           Class cls = cl.loadClass(类的全类名);
         */
        ClassLoader classLoader = dog.getClass().getClassLoader();
        Class<?> cls4 = classLoader.loadClass("Reflection.A_Example.Dog");

        /*
           方法五：
           基本数据(int, char,boolean,float,double,byte,long,short)按如下方式得到Class类对象：
           Class cls = 基本数据类型.class
         */
        Class<Integer> integerClass = int.class;

        /*
           方法六：
           基本数据类型对应的包装类，可以通过.TYPE得到Class类对象：
           Class cls = 包装类.TYPE
         */
        Class<Integer> type = Integer.TYPE;

    }

}
