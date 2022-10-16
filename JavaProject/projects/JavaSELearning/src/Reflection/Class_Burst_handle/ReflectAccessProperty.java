package Reflection.Class_Burst_handle;
import java.lang.reflect.Field;
/*
 * 反射暴破操作属性
 */
public class ReflectAccessProperty {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {

        Class<?> aClass = Class.forName("Reflection.Class_Burst_handle.Student");
        //创建对象
        Object o = aClass.newInstance();

        //获取public属性age
        Field age = aClass.getField("age");
        //修改属性值
        age.set(o,20);
        System.out.println(o);

        //获取private属性name
        Field name = aClass.getDeclaredField("name");
        //修改属性值
        //暴破
        name.setAccessible(true);
        name.set(o,"我妻善逸");
        //由于name是static的，也可以这样写：
        //name.set(null,"我妻善逸");
        System.out.println(o);
    }
}

class Student{
    public int age = 19;
    private static String name = "嘴平伊之助";

    public Student(){

    }

    @Override
    public String toString() {
        return "Student{" +"age=" + age +","+"name="+ name +'}';
    }
}