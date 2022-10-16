package Thread_based_learning.Thread_Synchronized;
/*
 * 线程同步机制：
 * 1.  在多线程编程，一些敏感数据不允许被多个线程同时访问，此时就使用同步访问机制， 
 *     保证数据在任何时刻，最多有一个线程访问，以保证数据的完整性。
 * 2.  线程同步，即当有一个线程在对内存进行操作时，其他线程都不可以对这个内存地址进行操作， 
 *     直到该线程完成操作，其他线程才能对该内存地址进行操作
 *
 * 使用synchronized实现同步：
 * 1. 被synchronized关键字修饰的方法，将变成同步方法
 * 2. 被synchronized关键字修饰的代码块，将变成同步代码块
 *
 * 3.  synchronized原理解释： 
 *     3.1  在java语言中，任何一个对象都有一把互斥锁，其实这把锁就是一个标记；   
 *          任何一个类都有一把互斥锁，也是一个标记，不管创建几个对象，类锁只有一把 
 *     3.2  当几个线程执行到一个同步方法或同步代码块时（也就是被synchronized修饰）：   
 *          先执行到的线程（并发总会有先后）会拿到这个方法或代码块的对象锁，然后进入     
 *          执行代码，其他线程由于拿不到锁就开始等待，当前一个线程执行完毕，释放锁后， 
 *          其他线程争夺此锁，拿到的进去执行，其他的排队，依次类推
 *
 * 4.  synchronized使用细节： 
 *     3.1  同步方法和同步代码块的对象锁，必须是线程共享的对象的锁，否则锁不住 
 *     3.2  synchronized修饰方法时，该方法对象锁指的就是调用这个方法的对象的锁（this）   
 *     3.3  synchronized修饰代码块时，该代码块对象锁就是括号中填入的对象的锁，因此这里     
 *          必须填入同步线程的共享的对象，否则每个线程都能拿到锁，无法实现同步 
 *     3.4  如果synchronized修饰的方法是静态的，则它的锁指的是这个方法的类的类锁， 
 *          如果synchronized修饰的代码块处于静态方法中，则括号内应该这样写：       
 *          synchronized(XXX.class){} 使用该静态方法的类的类锁 
 *
 * 以下通过同步方法解决“超卖”问题：
 */
public class Synchronized_01 {
    public static void main(String[] args) {

        SellTicket01 sell01 = new SellTicket01();

        //创建三个线程，三个线程都是对同一个对象（资源）sell01进行操作
        Thread thread1 = new Thread(sell01);
        Thread thread2 = new Thread(sell01);
        Thread thread3 = new Thread(sell01);

        //启动三个线程并发地进行售票
        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class SellTicket01 implements Runnable{

    //同一个资源
    private int ticket = 100;

    private boolean loop = true;//循环卖票控制

    //对进行买票的方法使用synchronized修饰，使其变为同步方法
    //线程执行该方法时，需要争夺调用该方法的对象的互斥锁，形成线程的同步
    public synchronized void sell(){

        if (ticket <= 0){
            System.out.println("票已售空");
            loop = false;
            return;
        }

        System.out.println(Thread.currentThread().getName()+"成功售出一张票，当前票剩余："+(--ticket));

    }

    @Override
    public void run() {

        while (loop) {

            sell();//在run()方法中循环调用同步方法

            //每卖一次休息一秒，展示出线程交替买票的效果
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
