package Collection_and_Map.Map_;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/*
 * LinkedHashMap介绍：
 * 1.  LinkedHashMap是维护了一个双向链表的哈希结构集合，他继承了HashMap，是线程不安全的
 * 2.  LinkedHashMap的数据结构是：数组+链表+红黑树+双向链表（双向链表是LinkedHashMap的特点）
 *     它通过继承获得了HashMap的数据结构，又独立维护了一个双向链表，来维护元素加入集合的次序
 * 3.  LinkedHashMap中存放元素的位置是LinkedHashMap的一个静态内部类对象Entry节点，
 *     Entry节点是HashMap中Node节点的子节点，拥有Node节点的所有属性外，Entry节点还设置了两个指针： 
 *     前指针before和后指针after，用于指向加入该LinkedHashMap集合的上一个元素和下一个元素， 
 *     也就是说当一个元素加入到集合中时，它的before会指向上一个加入集合的元素，不管这个元素存放在哪里，
 *     而上一个加入集合的元素的after会指向当前加入集合的这个元素，形成了一个双向链表， 
 *     从而保存了元素加入LinkedHashMap集合的顺序，这样在遍历的时候可以根据这个引导按照加入顺序取出元素， 
 *     使得LinkedHashMap的元素看起来是“有序的”， 
 *     但实际上仍是无序的，只不过通过一个双向链表记录了元素的加入顺序，也不支持索引
 * 4.  LInkedHashMap中有一个属性：accessOrder  
 *     决定链表的存储方式，false按照插入顺序存储，true表示按照访问(LRU)顺序存储 
 *     按访问顺序遍历：此时任何一次的操作，包括put、get操作，都会改变map中已有的存储顺序 
 *     按插入顺序遍历：只会根据元素插入集合的先后顺序进行遍历 
 *     不用指定accessOrder的构造器，默认是false，插入顺序存储，遍历时根据插入顺序遍历
 */
public class LinkedHashMap_ {

    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //使用无参构造，默认使用插入顺序遍历
        Map map = new LinkedHashMap();

        //向map中加入3个留学生键值对
        map.put(new Student("瑞克",1901),"留学生");
        map.put(new Student("达里尔",1902),"留学生");
        map.put(new Student("格伦",1903),"留学生");

        //直接输出，输出顺序和添加顺序一致
        System.out.println(map);
        //替换一个元素的value值，也不会影响输出顺序
        map.put(new Student("瑞克",1901),"留学研究生");
        //使用迭代器遍历，输出顺序和添加顺序一致
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("-----------------------------------------------------------");


        //使用有参构造，使用访问顺序遍历（LRU：最近最少未访问）
        Map map1 = new LinkedHashMap(16,0.75f,true);

        //向map1中加入3个留学生键值对
        map1.put(new Student("瑞克",1901),"留学生");
        Student Daryl = new Student("达里尔",1902);
        map1.put(Daryl,"留学生");
        map1.put(new Student("格伦",1903),"留学生");

        //此时的输出顺序和插入的顺序一样，因为还没有任何访问操作
        //最后插入的相当于最近被访问，会被插入双向链表末尾，最后输出
        System.out.println(map1);

        //替换一个元素的value值，该元素为目前最近访问的，会被插入到链表末尾（越近被访问的越靠近末尾）
        map1.put(new Student("瑞克",1901),"留学研究生");
        //此时再输出，瑞克会最后输出
        System.out.println(map1);
        //get()访问一个元素，该元素为目前最近访问的，会被插入到链表末尾
        map1.get(Daryl);
        //此时再输出，达里尔会最后输出
        System.out.println(map1);

    }
}
