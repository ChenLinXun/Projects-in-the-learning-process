package API_Learning.String_;
import java.lang.reflect.Field;
/*
 * 这里演示使用反射暴破修改String对象的值，除此方法外其他“修改”方法都只是创建新的String对象
 * 具体解释看Reflection包下的反射内容
 */
public class ModifyString {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        //引用A和B都指向字符串常量池中的同一个对象
        String A ="瑞克";
        String B ="瑞克";

        Class<? extends String> aClass = A.getClass();
        Field value = aClass.getDeclaredField("value");
        value.setAccessible(true);
        char[] C = {'格','伦'};
        value.set(A,C);

        System.out.println(B);//已发生改变
        //判断A和B是否仍然指向同一对象，比较地址
        System.out.println(A == B);//仍然指向同一对象
        //判断A和B在字符串常量池中的引用
        System.out.println(A.intern() == B.intern());//仍然是同一引用

        //如果不使用反射，则无法真正修改原String对象的内容，而是重新创建了另一个新的String对象
        B = "卡尔";
        System.out.println(B);
        System.out.println(A == B);
        System.out.println(A.intern() == B.intern());
    }
}
