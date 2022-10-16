package Collection_and_Map.Map_;
import java.util.*;
/*
 * 由于Map接口没有实现Iterable（可迭代的）接口，而且Map集合是不支持索引的，
 * 所以Map集合对象不可以直接进行遍历，为了方便程序员遍历Map集合，
 * Map集合提供了三个方法，可以返回Map的元素视图：
 * 1.  keySet() ：返回一个这个Map键key 的Set集合
 * 2.  values() ：返回一个这个Map键值value的Collection集合
 * 3.  entrySet()：返回一个这个Map键值对的Set集合
 * 这三个方法返回的Map视图集合，都实现了Iterable（可迭代的）接口，因此可以调用他们的迭代器进行遍历
 * （关于这个元素视图的实现详细看Map接口实现类里的讲解）
 */
public class iterator {

    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //以HashMap集合为例遍历(其他Map集合都一样)：

        Map map = new HashMap();

        map.put("no1","Rick");
        map.put("no2","Daryl");
        System.out.println(map);

        //通过entrySet集合遍历HashMap元素
        Set entrySet = map.entrySet();

        //增强for循环遍历，实际还是调用迭代器
        for (Object entry : entrySet) {
            Map.Entry node = (Map.Entry) entry; //向下转型
            System.out.println("key-"+node.getKey());
            System.out.println("value-"+node.getValue());
        }
        System.out.println("--------------------------------");

        Iterator it = entrySet.iterator();
        //返回（遍历顺序）第一个元素Node，而Node类属于HashMap的内部类，所以先用Object接收，再向下转型
        //其实也可以：Map.Entry next = (Map.Entry)it.next();
        Object next = it.next();
        Map.Entry node = (Map.Entry) next; //向下转型
        //修改该元素value值
        node.setValue("Glen");

        //遍历证明元素value值已被修改
        it = entrySet.iterator();//重置一下迭代器
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("--------------------------------");


        //通过keySet遍历HashMap元素键key：
        Set keySet = map.keySet();
        for (Object key : keySet) {
            System.out.println(key);
        }
        Iterator it1 = keySet.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }
        System.out.println("--------------------------------");


        //通过values遍历HashMap元素键值value
        Collection values = map.values();
        for (Object value : values) {
            System.out.println(value);
        }
        Iterator it2 = values.iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }

    }

}
