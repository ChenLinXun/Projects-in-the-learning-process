package Lock_;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
 * 可重入锁：拿到锁后，若执行某段代码或调用某个同步方法再次需要锁，则可以直接获取锁，直接进入，
 * 因为不仅同一把锁，而且能重复获取，所以！注意，获取两次锁，就要释放两次锁，否则视为没有释放锁
 * 反之也一样，释放几次锁就对应上了几次锁，不能多余释放，
 * 否则报非法监视器状态异常：Illegal Monitor State Exception
 * 底层解释：可重入锁底层有锁的计数器，当一个线程获取该锁后，可以不断再次获取，
 * 每次获取计数器都自增1，所以要等到锁的计数器下降为0时才能释放锁
 *
 * 不可重入锁：拿到锁后，若执行某段代码或调用某个同步方法再次需要锁，那么无法再次获得，
 * 因为虽然是同一把锁，但是不能重复获取，必须先释放锁，再拿到锁
 * 底层解释：不可重入锁底层没有锁的计数器，当一个线程获取一次锁后，无法再次获取
 *
 * 这两种锁的实现都是和底层的设计有关的
 * 可重入锁可以递归执行同步方法，而不可重入锁不能进行递归
 */
public class Reentrant_nonReentrant_lock {

    public static void main(String[] args) {

        Phone phone = new Phone();
        Computer computer = new Computer();

        new Thread(()->{phone.send();},"A线程").start();
        new Thread(()->{phone.call();},"B线程").start();

        new Thread(()->{computer.play();},"C线程").start();
        new Thread(()->{computer.play();},"D线程").start();

    }
}

//synchronized对象锁也是可重入锁，而且自动上锁解锁，获取几次就释放几次
class Phone{

    public synchronized void send(){
        System.out.println(Thread.currentThread().getName()+"发短信");
        call();
    }

    public synchronized void call(){
        System.out.println(Thread.currentThread().getName()+"打电话");
    }
}

//Lock锁也是可重入锁，上锁解锁非自动，要注意每次上锁解锁（成对出现）
class Computer{

    private Lock lock = new ReentrantLock();

    //上锁解锁成对出现，上几次就解几次，否则视为没有释放锁，其他线程无法再获取该锁(可以注释调试)
    //也不能多余释放，否则报非法监视器状态异常
    public void play(){

        lock.lock();//第一次上锁

        try{

            System.out.println(Thread.currentThread().getName()+"先打游戏");

            lock.lock();//第二次上锁
            try {
                System.out.println(Thread.currentThread().getName()+"再看电影");
            }finally {
                lock.unlock();//解第二次上的锁
            }

        }finally {
            lock.unlock();//解第一次上的锁
        }

    }
}
