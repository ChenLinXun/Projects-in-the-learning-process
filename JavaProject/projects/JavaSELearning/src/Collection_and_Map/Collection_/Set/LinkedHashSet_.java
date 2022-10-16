package Collection_and_Map.Collection_.Set;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
/*
 * LinkedHashSet介绍：
 * 1.  LinkedHashSet是HashSet的子类
 *
 * 2.  LinkedHashSet的底层实际上是LinkedHashMap，LinkedHashMap是HashMap的子类
 *
 * 3.  LinkedHashSet继承了HashSet维护的用于存放数据的HashMap对象map，而LinkedHashSet
 *     存放数据的底层容器是LinkedHashMap，所以LinkedHashSet的所有构造器进行构造时，
 *     会调用父类HashSet的构造：HashSet(int initialCapacity, float loadFactor, boolean dummy)
 *     该构造将维护的这个map指向新创建的LinkedHashMap对象（向上转型），这样LinkedHashSet底层
 *     维护的map的实际（运行）类型就是LinkedHashMap类型了，真正存放LinkedHashSet元素的地方
 *
 * 4.  LinkedHashMap中存放元素的位置是LinkedHashMap的一个静态内部类对象Entry节点，
 *     Entry节点是HashMap中Node节点的子节点，拥有Node节点的所有属性外，
 *     Entry节点还设置了两个指针： 前指针before和后指针after，
 *     用于指向加入该LinkedHashMap集合的上一个元素和下一个元素，
 *     也就是说当一个元素加入到集合中时，它的before会指向上一个加入集合的元素，不管这个元素存放在哪里，
 *     而上一个加入集合的元素的after会指向当前加入集合的这个元素，形成了一个双向链表，
 *     从而保存了元素加入LinkedHashMap集合的顺序，这样在遍历的时候可以根据这个引导按照加入顺序取出元素，
 *     使得LinkedHashMap的元素看起来是“有序的”，
 *     但实际上仍是无序的，只不过通过一个双向链表记录了元素的加入顺序，也不支持索引
 *
 * 5.  因为LinkedHashSet的底层是LinkedHashMap，所以其数据结构就是LinkedHashMap的数据结构
 *
 * 6.  LinkedHashMap的数据结构：数组+链表+双向链表 
 *     LinkedHashMap的数据结构和HashMap基本一致，都是hash结构，表头后面的单链表会进行树化 
 *     唯一的区别仅仅是LinkedHashMap比HashMap多了一个维护元素加入次序的双向链表
 *
 * LinkedHashSet扩容和树化机制：
 * 1.  LinkedHashSet的底层是LinkedHashMap，
 *     而LinkedHashMap的表头table，是从HashMap继承下来的，也就是说，
 *     LinkedHashMap的表头数组就是Node[]数组，而挂载到表头上的元素， 
 *     是Node节点的子节点，Entry节点，所以这里相当于是一个多态数组
 *
 * 2.  所以LinkedHashSet的扩容机制和树化机制和HashSet是完全一致的
 */
public class LinkedHashSet_ {

    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //下断点调试以下代码：

        //使用无参构造，默认表头容量0，默认扩容因子0.75
        Set set = new LinkedHashSet();

        //第一次扩容，默认表头扩容至16
        set.add("java");

        //在Dog链表上添加8个元素
        for (int i = 0; i < 8; i++) {
            set.add(new Dog(i));
        }

        //在Cat链表上添加3个元素
        for (int i = 0; i < 3; i++) {
            set.add(new Cat(i));
        }

        //当前元素个数为12，再加一个元素会触发扩容
        //表头容量变成32
        set.add(new Cat(3));

        //再加入一只狗，在狗的链表上元素个数超过了树化阈值8，但当前表头容量没到64，
        //所以会触发扩容，不触发树化
        set.add(new Dog(8));

        //当前表头容量扩为64
        //当加入一只猫，猫的链表元素还没超过树化阈值8，所以既不会树化也不会触发扩容
        set.add(new Cat(4));

        //但现在加入一只狗，狗的链表元素已经超过了树化阈值8，并且表头容量目前达到了64
        //因此这条狗链表会进行树化
        set.add(new Dog(9));

        //输出顺序和添加顺序一致，看起来“有序”，实际还是无序的
        System.out.println(set);

        //用迭代器输出
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
