package Collection_and_Map.Collection_.Set;
import java.util.*;
/*
 * Set接口介绍:
 * 1.  Set 接口是Collection 接口的子接口
 * 2.  Set集合类中元素是无序的(即添加顺序和取出顺序不一致)
 *     但是取出的顺序是固定的，确定了取出顺序后就不再改变了
 * 3.  Set集合元素不可重复，所以最多只能有一个null
 * 4.  Set集合不支持索引
 *
 * HashSet介绍:
 * 1.  和List集合不同，HashSet是无序的单列集合
 * 2.  HashSet的底层实际上是HashMap； 
 *     HashSet维护了一个HashMap对象来存放元素，因此HashSet是线程不安全的
 * 3.  HashMap底层是：数组+链表(可能树化成红黑树)+红黑树（由链表转变）的数据结构，
 *     （Hash的意思是：散列表，散列表也称哈希表）
 * 4.  HashSet顾名思义也是用到了这样的Hash结构，这样的结构元素是无序存放的
 * 5.  注意的是，HashMap中的Node节点和TreeNode节点存储数据既有键Key，又有键值value，
 *     是以键值对的形式存储的，因此知道HashMap是双列集合； 
 *     而HashSet是单列集合，既为了通过HashMap构成散列表结构，实现无序， 
 *     又为了符合单列，HashSet底层构建HashMap对象来存储元素时： 
 *     会默认将HashMap对象的键Key作为存放HashSet元素的地方， 
 *     而将HashMap对象的键值value用一个所有HashSet元素共享的Object对象来赋值，只是起到一个占位的作用     这样HashSet就能够使用到数组+链表(会树化)的数据结构来存储数据，而不用单独重新完成这个数据结构了
 *
 * HashSet扩容和树化机制:
 * 1.  HashSet底层是HashMap，因此HashSet的扩容机制实际上是HashMap的扩容机制：
 * 2.  HashMap表头扩容机制：     
 *      2.1  HashMap设置了一个表头扩容临界值threshold，当HashMap元素个数size超过它时       
 *           会对表头数组扩容2倍；     
 *      2.2  扩容临界值 = 当前表头数组容量 * 扩容因子
 *      2.3  扩容因子loadFactor，不用指定扩容因子构造器构造，默认是0.75
 *      2.4  使用无参构造，默认扩容因子0.75，第一次扩容时，默认表头数组容量为16，因此
 *           扩容临界值为12；HashMap元素超过12个时，扩容至32，临界值变成24，以此类推
 *      2.5  当某条链表的元素个数超过TREEIFY_THRESHOLD(默认是8)，table大小没到           
 *           MIN TREEIFY CAPACITY(默认64)，会对table扩容2倍
 * 3.  HashMap链表树化机制（红黑树）：
 *     在Java8中,如果一条链表的元素个数超过 TREEIFY_THRESHOLD(默认是8)，
 *     并且table的大小>=MIN TREEIFY CAPACITY(默认64)，就会进行树化(红黑树)
 *     否则采用扩容机制对表头扩容2倍
 */
public class HashSet_ {

    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //下断点调试以下代码：

        //验证扩容和树化机制：
        //使用无参构造，默认表头容量0，默认扩容因子0.75
        Set set = new HashSet();

        //第一次扩容，默认表头扩容至16
        set.add("java");
        //可以加入null，只能一个
        set.add(null);
        //不是重复元素，可以添加
        set.add("php");
        //不是重复元素，可以添加
        set.add("python");
        //重复元素，添加失败
        set.add("java");

        //重写了Dog和Cat类的hashCode方法，会把不同对象的Dog都加到一个链表上
        for (int i = 1; i < 8; i++) {
            set.add(new Dog(i));
        }

        set.add(new Cat(1));
        //当前元素个数为12，再加一个元素会触发扩容
        set.add(new Cat(2));

        //当前表头容量扩为32
        set.add(new Dog(8));
        //再加入一只狗，在狗的链表上元素个数超过了树化阈值8，但当前表头容量没到64，
        //所以会触发扩容，不触发树化
        set.add(new Dog(9));

        //当前表头容量扩为64
        //当加入一只猫，猫的链表元素还没超过树化阈值8，所以既不会树化也不会触发扩容
        set.add(new Cat(3));

        //但现在加入一只狗，狗的链表元素已经超过了树化阈值8，并且表头容量目前达到了64
        //因此这条狗链表会进行树化
        set.add(new Dog(9));

        //set集合是无序的，输出顺序和存放顺序不一致
        System.out.println(set);
        //但确定了输出顺序后就不会改变
        System.out.println(set);
        System.out.println("--------------------------------------------------------------");

    }

}

class Dog{
    int i;
    public Dog(int i) {
        this.i = i;
    }
    //为了验证扩容和树化机制，重写hashCode()方法，使每个Dog对象在HashSet中的索引都一样
    //不重写equals()方法，会使所有的这些Dog对象都是不重复的（因为默认比较地址）
    @Override
    public int hashCode() {
        return 100;
    }
    @Override
    public String toString() {
        return "Dog{" +
                "i=" + i +
                '}';
    }
}

class Cat{
    int i;
    public Cat(int i) {
        this.i = i;
    }
    //为了验证扩容和树化机制，重写hashCode()方法，使每个Cat对象在HashSet中的索引都一样
    //不重写equals()方法，会使所有的这些Cat对象都是不重复的（因为默认比较地址）
    @Override
    public int hashCode() {
        return 200;
    }
    @Override
    public String toString() {
        return "Cat{" +
                "i=" + i +
                '}';
    }
}
