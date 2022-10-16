package API_Learning.String_;
/* String结构剖析:
 * 1.String类表示字符串常量。Java 程序中的所有字符串文字，例如 "abc"，都是作为String类的实例实现的。
 *
 * 2.为什么说String类型是字符串常量？解释：  
 *   jdk8下在String类的底层，保存字符序列的，实际上是字符数组，jdk9后是字节数组，
 *   这两个数组的名字都是value，value是final类型，说明这个value数组的地址不可改变，
 *   虽然value数组的内容可变，但String类中没有设计改变String对象value属性内容的方法。
 *   所以说String类对象是不可变对象，被称为字符串常量，或字符串常量对象
 *
 * 3.字符串对象是不可变对象，一旦字符串对象被分配，其内容就不可改变：
 *   (1) Java设计者很小心地设计保护了String类中封装的数据，也就是字符串，
 *       不提供能修改String对象内容的方法，所有如replace()修改字符串的方法，
 *       实际都是返回了一个新建的String对象，而不是真正的修改原来的String对象。
 *   (2) 而像：     
 *       s1 = "aa";     
 *       s1 = "bb";     
 *       的“修改”方式，实际上是在字符串常量池中新建了"bb"字符串对象，让s1指向它而已，
 *       则此时"aa"对象已经没有引用指向它了
 *   (3) 因此字符串对象一旦创建，则之后的修改操作都是创建另一个新的字符串对象
         注意：除非使用反射暴破！
 *
 * 4.  String类较常用构造方法(其它看手册):   
 *     new String();   
 *     new String (String original); 
 *     new String(char[] a); 
 *     new String(char[]a,int startIndex,int count);
 *
 * 5.  除了s1 = "aa"; new String();new String (String original); 
 *     这种出现字符串字面量的构造方式会在字符串常量池中创建对象外，其他的方法都不会在池中创建对象
 *
 * 6.  String类中重写了equals()和hashCode()方法：
 *     比较两个String对象的底层字符数组value的每一个字符，
 *     如果相同，则equals()返回true，hashCode()返回相同的hashCode值
 */
public class String_Structure {

    public static void main(String[] args) {

        //以下程序可以debug追源码了解创建String对象原理
        //若创建方式没有在池中创建String对象，则s.intern() == s返回true，反之false

        String s = new String();
        System.out.println(s);
        System.out.println("在池中创建了对象："+!(s.intern() == s));
        System.out.println("------------------------------------------------");

        String s1 = new String("hello");
        System.out.println(s1);
        System.out.println("在池中创建了对象："+!(s1.intern() == s1));
        System.out.println("------------------------------------------------");

        char[] c = {'H','e','l','l','o'};
        String s2 = new String(c);
        System.out.println(s2);
        System.out.println("在池中创建了对象："+!(s2.intern() == s2));
        System.out.println("------------------------------------------------");

        String s3 = new String(c, 1, 4);
        System.out.println(s3);
        System.out.println("在池中创建了对象："+!(s3.intern() == s3));
        System.out.println("------------------------------------------------");

        //直接字面量拼接
        String T = "A"+"B";
        //直接拼接经过编译器优化编译后相当于String T = "AB";
        System.out.println(T);
        System.out.println("直接在池中创建对象："+(T.intern() == T));
        System.out.println("------------------------------------------------");


        //含字符串对象的拼接
        String a = "a";
        String t = a + "b";//在这里下断点debug可以发现：
        //先创建了一个StringBuilder，然后调用两次append依次把"a","b"加进去，
        //然后调用toString方法，toString方法中用String(char value[], int offset, int count)构造器
        //创建了一个值为"ab"的String对象并返回

        //所以这样创建的结论是，t在堆中创建了一个String对象，在池中不创建
        System.out.println(t);
        System.out.println("在池中创建了对象："+!(t.intern() == t));//false

    }
}
