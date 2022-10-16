package Lock_;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/*
 * 读写锁：
 * 读锁：又称共享锁，多个线程可以共享该锁，也就是该锁不是互斥锁，多个线程不需要进行同步读取
 * 写锁：又称独占锁，同时只能有一个线程占有该锁，也就是互斥锁，多个线程同步进行写入操作
 *
 * 写锁高于读锁，锁只能降级，不能升级，当获得写锁后，若要进行读操作，可以将写锁降级为读锁，
 * 进行读操作，也就是写的时候可以读
 * 读锁低于写锁，当获得读锁后，若要进行写操作，由于读锁无法升级为写锁，则必须释放读锁后，
 * 争夺到写锁，才能进行写操作
 *
 * 优点：读操作可以同时进行，提高效率
 *
 * 缺点：执行写操作时可以读，但是读操作时不能写，可能有的线程会一直读，无法写，造成锁饥饿
 *
 * ReentrantReadWriteLock的使用：
 */
public class ReadWriteLock_ {

    public static void main(String[] args) {

        Source source = new Source();

        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(()->{
                source.write(String.valueOf(temp),temp);
            },"线程"+(i)).start();
        }

        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(()->{
                source.read(String.valueOf(temp));
            },"线程"+(i)).start();
        }

    }

}

class Source{

    private volatile HashMap<String, Object> map = new HashMap<>();

    private  ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public Object read(String key){//读操作

        readWriteLock.readLock().lock();//使用读锁进行锁定
        Object result = null;

        try {
            System.out.println(Thread.currentThread().getName()+"正在读取数据");
            result=  map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取数据完毕");
        } finally {
            readWriteLock.readLock().unlock();//解开读锁
        }

        return result;
    }

    public void write(String key,Object value){//写操作

        readWriteLock.writeLock().lock();//使用写锁进行锁定

        try {
            System.out.println(Thread.currentThread().getName()+"正在写数据");
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写数据完毕");
        } finally {
            readWriteLock.writeLock().unlock();//解开写锁
        }
    }

}