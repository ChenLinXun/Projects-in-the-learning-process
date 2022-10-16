package Collection_thread_unsafe;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
/*
 * HashSet和HashMap线程不安全的解决方案
 */
public class Hash_thread_unsafe {

    public static void main(String[] args) {

        /*
            HashSet线程不安全
            Set<String> set = new HashSet<>();

            for (int i = 0; i < 10; i++) {
                new Thread(()->{
                    set.add(UUID.randomUUID().toString().substring(0,5));
                    System.out.println(set);
                },String.valueOf(i)).start();
            }
         */

        //HashSet线程不安全解决方案：
        //使用JUC包下的CopyOnWriteArraySet替代
        //CopyOnWriteArraySet利用了JUC的并发技术，高效解决并发问题
        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },String.valueOf(i)).start();
        }


        /*
            HashMap线程不安全
            Map<String,String> map = new HashMap<>();

            for (int i = 0; i < 10; i++) {
                String key = String.valueOf(i);
                new Thread(()->{
                    map.put(key,UUID.randomUUID().toString().substring(0,5));
                    System.out.println(map);
                },String.valueOf(i)).start();
            }
         */

        //HashMap线程不安全解决方案
        //使用JUC包下的ConcurrentHashMap替代
        //ConcurrentHashMap利用了JUC的并发技术，高效解决并发问题
        Map<String,String> map = new ConcurrentHashMap<>();

        for (int i = 0; i < 10; i++) {
            String key = String.valueOf(i);
            new Thread(()->{
                map.put(key,UUID.randomUUID().toString().substring(0,5));
                System.out.println(map);
            },String.valueOf(i)).start();
        }

    }

}
