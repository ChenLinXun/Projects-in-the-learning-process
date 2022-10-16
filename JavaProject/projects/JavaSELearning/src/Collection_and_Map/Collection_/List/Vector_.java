package Collection_and_Map.Collection_.List;
import java.util.List;
import java.util.Vector;
/*
 * Vector注意事项：
 * 1.  Vector底层也是一个对象数组，可以加入null,并且多个
 * 2.  Vector是线程同步的,即线程安全, Vector类的操作方法带有synchronized
 * 3.  在开发中,需要线程同步安全时,，考虑使用Vector，但效率较低
 * 4.  ArrayList和Vector都继承了AbstractList，AbstractList实现了List接口的部分方法， 
 *     以及toString方法，这样这些方法就不需要ArrayList和Vector各自重复实现一遍了， 
 *     他们只需要实现各自的独特的方法
 *
 * Vector扩容机制：
 * 1.  调用指定初始容量和自动增量的构造： 
 *     若传入的自动增量大于0，则每次扩容，容量扩为原容量加上这个增量   
 *     若传入自动增量小于等于0，每次扩容成两倍
 * 2.  调用指定初始容量的构造： 
 *     该构造会调用指定初始容量和自动增量的构造， 
 *     并传入自动增量参数为0；默认扩容时扩成两倍
 * 3.  调用无参构造： 
 *     该构造会调用指定初始容量的构造，并传入初始容量10， 
 *     默认构造一个初始容量为10的Vector，扩容时默认扩成两倍
 */
public class Vector_{

    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //下断点调试以下代码：

        //使用指定容量和扩容增量的有参构造，需要扩容时每次增加扩容增量
        List list = new Vector(1,3);
        //当前容量为1，不需要扩容
        list.add("hahahah");
        //需要扩容，容量加3，扩容为4
        list.add("heiheiheihei");
        System.out.println(list);


        //使用指定容量的有参构造，需要扩容时每次扩容2倍
        List list1 = new Vector(0);
        //当前容量为0，加入aa需要扩容
        //扩容为当前容量的2倍，由于当前容量为0，触发修补机制，当前容量扩充为最小容量：1
        list1.add("aa");
        //当前容量为1，加入bb需要扩容，扩容成当前容量的2倍
        list1.add("bb");


        //使用无参构造，默认设置初始容量为10
        List list2 = new Vector();
        //当前容量为10，不需要扩容
        list2.add("cc");
        //再加入9个元素
        for (int i = 0; i < 9; i++) {
            list2.add("dd");
        }
        //此时容量已用满，需要扩容，扩容成2倍：20
        list2.add("ee");

    }
}
