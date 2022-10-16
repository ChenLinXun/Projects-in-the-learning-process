package Collection_thread_unsafe;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
/*
 * Arraylist集合线程不安全的解决方案
 */
public class List_thread_unsafe {

    public static void main(String[] args) {

        /*
            Arraylist线程不安全
            List list = new ArrayList();

            for (int i = 0; i < 10; i++) {
                new Thread(()->{
                    list.add(UUID.randomUUID().toString().substring(0,5));
                    System.out.println(list);
                },String.valueOf(i)).start();
            }
         */

        //解决方案一，用线程安全的Vector替代，比较古老，一般不使用
        List<String> list1 = new Vector<>();

        for (int i = 0; i < 10; i++) {//创建10个线程对同一个list进行写和读操作
            new Thread(()->{
                list1.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list1);
            },String.valueOf(i)).start();
        }

        //解决方案二，用Collections工具类下的synchronizedList替代，也比较古老，一般不使用
        List<String> list2 = Collections.synchronizedList(new ArrayList<>());

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list2.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list2);
            },String.valueOf(i)).start();
        }

        //解决方案三，使用JUC包下的CopyOnWriteArrayList替代，效率最高，当前普遍的解决方案
        //CopyOnWriteArrayList利用了JUC的并发技术，实现了写时复制技术，高效解决并发问题
        //写时复制技术：
        // 在对集合写操作时，先赋值一份原来的集合，在备份上进行写，最后再覆盖回去，
        // 这个过程是受并发控制的，利用了Lock锁控制（具体可以看CopyOnWriteArrayList的源码）
        List<String > list3 = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list3.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list3);
            },String.valueOf(i)).start();
        }
    }

}
