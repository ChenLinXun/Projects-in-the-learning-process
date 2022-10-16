package Reflection.Class_Burst_handle;
import java.lang.reflect.Field;
/*
 * 利用反射，暴破修改String对象内容
 * String所谓的“不可变类型”在反射面前可笑至极
 */
public class ReflectBurstModifyString {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        //引用A和B都指向字符串常量池中的同一个对象
        String A ="灶门炭治郎";
        String B ="灶门炭治郎";

        //获取A所指对象的Class对象
        Class<? extends String> aClass = A.getClass();
        //获取String对象中存储字符串信息的属性：value字符数组
        Field value = aClass.getDeclaredField("value");
        //暴破！反射面前一切都是纸老虎，破坏String的封装性
        value.setAccessible(true);
        //修改A所指String对象的value属性
        char[] C = {'炼','狱','杏','寿','郎'};
        value.set(A,C);
        //输出B所指对象（也就是A所指对象）内容
        System.out.println(B);//已发生改变

        //判断A和B是否仍然指向同一对象，比较地址
        System.out.println(A == B);//仍然指向同一对象
        //判断A和B在字符串常量池中的引用
        System.out.println(A.intern() == B.intern());//仍然是同一引用
        //结论：原为"灶门炭治郎"的字符串对象中的内容已经被反射暴破改变

        //如果不使用反射，则无法真正修改原String对象的内容，而是重新创建了另一个新的String对象
        B = "富冈义勇";
        System.out.println(B);
        System.out.println(A == B);
        System.out.println(A.intern() == B.intern());
    }
}


