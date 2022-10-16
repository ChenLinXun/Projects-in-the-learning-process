package Lock_;
/*
 * ReentrantLock无参构造默认构造非公平锁，传入参数true构造公平锁
 *
 * 公平锁：先来后到，排队取锁，不能插队，不会出现线程饿死问题，效率较低
 *
 * 非公平锁：谁抢到就是谁的，可以插队，可能出现线程饿死问题，效率较高
 * 一般默认为非公平锁，synchronized的对象锁就是一种非公平锁
 *
 */
import java.util.concurrent.locks.ReentrantLock;

public class fair_unfair_lock {

    public static void main(String[] args) {

        //创建资源类对象
        SellTicket sellTicket = new SellTicket();

        //创建三个线程对同一个资源类对象操作，可能出现某个线程一次也拿不到锁的情况
        //修改SellTicket中lock的构造方法，再次运行，就不会发生这样的情况
        new Thread(()->{for (int i = 0; i < 40; i++) sellTicket.sell();}).start();
        new Thread(()->{for (int i = 0; i < 40; i++) sellTicket.sell();}).start();
        new Thread(()->{for (int i = 0; i < 40; i++) sellTicket.sell();}).start();

    }

}

//创建资源类
class SellTicket{

    //创建可重入锁(无参构造，默认为非公平锁)
    private final ReentrantLock lock = new ReentrantLock();

    //资源属性
    private int ticket = 40;

    //资源方法
    public void sell(){

        //上锁
        lock.lock();

        //使用try-finally，防止出现异常导致没有解锁的情况
        try {
            if (ticket <= 0){
                System.out.println("票已售空");
                return;
            }

            System.out.println(Thread.currentThread().getName()+"成功售出一张票，当前票余："+(--ticket));
        } finally {
            //解锁
            lock.unlock();
        }

    }

}