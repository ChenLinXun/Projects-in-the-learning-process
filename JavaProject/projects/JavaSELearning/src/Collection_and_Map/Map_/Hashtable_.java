package Collection_and_Map.Map_;
import java.util.Hashtable;
/*
 * Hashtable介绍：
 * 1.  哈希表（Hashtable）又叫做散列表，是根据关键码值（即键值对）而直接访问的数据结构。
 * 2.  Hashtable是线程安全的，效率相比HashMap较低
 * 3.  Hashtable底层是：数组+链表 的数据结构，因此Hashtable通过拉链法解决哈希碰撞 
 *     与HashMap不同的是Hashtable的链表不会树化来提高效率4.  Hashtable底层数据结构的实现：
 *     Hashtable底层实际上通过一个静态内部类Entry节点来存放数据，两个存放数据的位置：
 *     key存放元素的键，value存放元素的键值；同时该节点类中包含了一个后指针（Entry类型），
 *     用来指向该节点后面的节点；Hashtable底层同时又设置了一个Entry数组作为表头，
 *     每个数组元素后都可以挂载其他的Entry节点，于是数组+链表的散列表结构就形成了
 * 5.  Hashtable的key和value都不能为null
 *
 * Hashtable表头扩容机制：
 * 1.  Hashtable设置了一个表头扩容临界值threshold，当Hashtable元素个数count超过它时会对表头数组扩容2倍并加1
 * 2.  扩容临界值 = 当前表头数组容量 * 扩容因子
 * 3.  扩容因子loadFactor，不用指定扩容因子构造器构造，默认是0.75     
 * 4.  Hashtable的构造器在构造对象时，若表头容量未指定或设置为0，会直接进行容量初始化，
 *     而不是在put()方法里进行，这一点和HashMap不同     
 * 5.  使用无参构造，默认扩容因子0.75，并在构造中进行容量初始化，表头数组容量默认扩为11     
 * 6.  使用有参构造，传入表头数组容量为0，并在构造中进行容量初始化，表头数组容量扩为1     
 * 7.  使用有参构造，传入非0的表头容量，则根据该容量进行容量初始化
 * 8.  Hashtable表头进行扩容后会改变原元素的索引值，也就是会移动原来的链表
 */
public class Hashtable_ {

    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //下断点调试以下程序：
        //验证Hashtable扩容机制：

        //调用无参构造，默认初始容量为11，扩容因子0.75，此时扩容阈值为8
        Hashtable table = new Hashtable();

        //添加第一个元素
        table.put("Java","1.8");

        //添加7个元素，这7个元素的键都是Cat对象，Cat对象hashCode值都相同都会挂载到一条链表上
        for (int i = 0; i < 7; i++) {
            table.put(new Cat(i),"星星猫咖");
        }
        //此时元素总个数为8，再添加一个元素会进行扩容
        //扩容后会发现"Java"和Cat链表的索引位置都发生了变化，扩容阈值变为17
        table.put(new Cat(7),"太阳猫咖");

        //再向Cat链表添加8个元素
        for (int i = 8; i < 16; i++) {
            table.put(new Cat(i),"月亮猫咖");
        }
        //此时元素总个数为17，再添加一个元素会进行扩容，并且"Java"和Cat链表的索引位置又发生了变化
        table.put(new Cat(16),"星星猫咖");
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