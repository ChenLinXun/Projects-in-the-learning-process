package Thread_based_learning.Thread_Synchronized;
/*
 * 类锁的使用
 */
public class Synchronized_03 {

    public static void main(String[] args) {

        //创建三个线程，三个线程都是对同一个资源：静态属性ticket 进行操作
        Thread thread1 = new SellTicket03();
        Thread thread2 = new SellTicket03();
        Thread thread3 = new SellTicket03();

        //启动三个线程并发地进行售票
        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class SellTicket03 extends Thread{

    private static int ticket = 100;//同一个资源

    private static boolean loop = true;//循环卖票控制

    public static void sell(){

        //使用同步代码块，所有对ticket进行售出操作的线程，都需要同步执行
        //因为sell()方法是静态的，所以这里使用类锁，或者使用线程共享的静态对象的锁
        synchronized(SellTicket03.class){

            if (ticket <= 0){
                System.out.println("票已售空");
                loop = false;
                return;
            }

            System.out.println(Thread.currentThread().getName() + "成功售出一张票，当前票剩余：" + (--ticket));
        }

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

