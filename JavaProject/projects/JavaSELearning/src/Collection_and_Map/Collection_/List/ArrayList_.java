package Collection_and_Map.Collection_.List;
import java.util.ArrayList;
import java.util.List;
/*
 * ArrayList注意事项
 * 1.  ArrayList可以加入null,并且多个
 * 2.  ArrayList是由数组来实现数据存储的
 * 3.  ArrayList基本等同于Vector，除了ArrayList是线程不安全(执行效率高)看源码. 
 *    在多线程情况下，不建议使用ArrayList
 * 4.  ArrayList和Vector都继承了AbstractList，AbstractList实现了List接口的部分方法， 
 *     以及toString方法，这样这些方法就不需要ArrayList和Vector各自重复实现一遍了， 
 *     他们只需要实现各自的独特的方法
 *
 * ArrayList扩容机制：
 * 1.  ArrayList中维护了一个Object类型的数组elementData
 * 2.  当创建ArrayList对象时，如果使用的是无参构造器，初始elementData容量为0， 
 *     第1次添加，则扩容elementData为10，如需要再次扩容，则扩容elementData为1.5倍。
 * 3.  如果使用的是指定大小的构造器，则初始elementData容量为指定大小，如果需要扩容, 
 *     则直接扩容elementData为1.5倍。
 */
public class ArrayList_ {

    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //下断点调试以下代码：

        //使用无参构造器构造
        List list = new ArrayList();
        //当前容量为0
        //加入AA后需要扩容，第一次扩容默认扩容为10
        list.add("AA");
        //加入BB，容量足够不需要扩容
        list.add("BB");
        //加入8个CC，容量已用满
        for (int i = 0; i < 8; i++) {
            list.add("CC");
        }
        //加入第11个元素，需要扩容，扩容1.5倍
        list.add("DD");


        //使用有参构造，需要扩容时每次扩容1.5倍
        List list1 = new ArrayList(0);
        //当前容量为0，加入aa需要扩容
        //扩容为当前容量的1.5倍，由于当前容量为0，触发修补机制，当前容量扩充为最小容量：1
        list1.add("aa");
        //当前容量为1，加入oo需要扩容
        //由于1.5倍扩容机制的写法是：旧容量加旧容量的一半，所以仍然会触发修补机制，当前容量扩充为2
        list1.add("oo");

        //使用有参构造，需要扩容时每次扩容1.5倍
        List list2 = new ArrayList(4);
        for (int i = 0; i < 4; i++) {
            list2.add("bb");
        }
        //容量已满，加入第五个元素需要扩容，扩容为4的1.5倍：6
        list2.add("cc");
    }

}













