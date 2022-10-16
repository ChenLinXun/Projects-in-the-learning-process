package Collection_and_Map.Collection_.List;
import java.util.LinkedList;
import java.util.List;
/*
 * LinkedList介绍：
 * LinkedList集合底层实际上是一个双向链表，LinkedList将集合的元素保存在双向链表的节点中，
 * 也就是说，底层双向链表节点的内容item就是保存的集合元素；
 * 在LinkedList中，链表节点是一个静态内部类，LinkedList集合每加入一个元素，
 * 底层就会创建一个Node节点对象，然后把元素保存到节点对象属性item中，最后把这个节点插入到双向链表里
 *
 * LinkedList注意事项：
 * 1.  LinkedList可以加入null，并且多个
 * 2.  LinkedList底层实际是通过节点存储元素，再把节点连接起来一起管理的，数据结构是双向链表
 * 3.  LinkedList实际上是链表，因此不存在扩容机制
 * 4.  LinkedList是线程不安全的
 * 5.  LinkedList直接父类AbstractSequentialList
 */
public class LinkedList_ {

    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //下断点调试以下代码：

        List list = new LinkedList();

        //添加元素，底层会默认调用LinkLast在双向链表末尾添加
        list.add("tom");

        //在指定索引位置添加元素，索引位置等于size，则调用LinkLast在双向链表末尾添加
        list.add(1,"jack");

        //在指定索引位置添加元素，索引位置不等于size，则调用LinkBefore在指定位置添加
        list.add(0,"chen");

        //可以添加null，并且多个
        list.add(null);
        list.add(null);
        list.add(null);

        //根据元素内容移除元素
        list.remove(null);
        //根据索引移除元素
        list.remove(2);

        //根据索引修改元素
        list.set(1,"Tom");

        System.out.println(list);

    }

}
