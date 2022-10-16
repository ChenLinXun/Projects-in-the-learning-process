package Reflection.Class_Burst_handle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/*
 * 反射暴破操作方法
 */
public class ReflectAccessMethod {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {

        Class<?> aClass = Class.forName("Reflection.Class_Burst_handle.Boss");

        //创建对象
        Object o = aClass.newInstance();
        //获取public方法hi
        Method hi = aClass.getDeclaredMethod("hi", String.class);
        //调用
        hi.invoke(o,"Rick");

        //获取private方法say
        Method say = aClass.getDeclaredMethod("say", int.class, String.class, char.class);
        //暴破，使得私有方法也能访问
        say.setAccessible(true);
        //调用
        System.out.println(say.invoke(o, 21, "炼狱杏寿郎", '柱'));
        //因为say()是静态方法，也可以这样调用：
        System.out.println(say.invoke(null, 21, "炼狱杏寿郎", '柱'));

        //在反射中，如果调用方法有返回值，统一用Object接收，实际（运行）类型仍与方法中定义的返回类型一致
        Object o1 = say.invoke(o, 21, "炼狱杏寿郎", '柱');
        System.out.println(o1.getClass());
    }
}

class Boss{
    public int age;
    private static String name;

    public Boss(){
    }

    private static String say(int n, String s, char c){
        return n + " " + s + " " + c;
    }

    public void hi(String s){
        System.out.println("hi " + s);
    }
}