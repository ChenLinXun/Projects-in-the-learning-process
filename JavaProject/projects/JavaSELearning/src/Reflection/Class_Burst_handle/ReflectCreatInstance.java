package Reflection.Class_Burst_handle;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
/*
 * 反射暴破创建实例
 */
public class ReflectCreatInstance {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //1. 调用类的无参构造器创建对象
        Class<?> aClass = Class.forName("Reflection.Class_Burst_handle.User");
        Object o = aClass.newInstance();
        System.out.println(o);

        //2. 调用指定的类的public有参构造器创建对象
        Constructor<?> constructor = aClass.getConstructor(String.class);
        Object o1 = constructor.newInstance("灶门炭治郎");
        System.out.println(o1);

        //3. 调用指定的类的非public有参构造器创建对象
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(int.class,String.class);

        //暴破，使用反射中的暴力破解，使得可以访问私有构造器，破坏其封装性，反射面前都是纸老虎
        declaredConstructor.setAccessible(true);//暴破

        Object o2 = declaredConstructor.newInstance(20,"富冈义勇");
        System.out.println(o2);

    }
}

class User{
    private int age = 20;
    private String name = "炼狱杏寿郎";

    public User(){//无参，public
    }

    public User(String name){
        this.name = name;
    }

    private User(int age, String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +"age=" + age +", name='" + name + '\'' + '}';
    }
}