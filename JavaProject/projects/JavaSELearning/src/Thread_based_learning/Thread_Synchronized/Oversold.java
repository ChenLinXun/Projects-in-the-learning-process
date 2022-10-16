package Thread_based_learning.Thread_Synchronized;
/*
 * 什么时候数据在多线程并发环境下会存在安全问题： 
 * 三个条件同时满足：1.多线程并发、2.有共享数据、3.共享数据有修改行为（光读取是不会发生安全问题的） 
 * 也就是，同一个对象被多个线程同时操作（也就是不同步操作），并对对象的数据有修改行为，
 * 会导致数据不安全，产生紊乱的问题 
 *
 * 以下模拟“超卖”现象的发生   
 */
public class Oversold {

    public static void main(String[] args) {

        SellTicket sell = new SellTicket();

        //创建三个线程，三个线程都是对同一个对象（资源）sell进行操作
        Thread thread1 = new Thread(sell);
        Thread thread2 = new Thread(sell);
        Thread thread3 = new Thread(sell);

        //启动三个线程并发地进行售票
        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class SellTicket implements Runnable{

    private int ticket = 20;//同一个资源

    @Override
    public void run() {

        while (true){

            //很有可能在最后一张票卖出时，由于还没有来得及ticket减一，另一个线程也执行到这并跳过了if判断
            //导致超卖现象的发生
            if (ticket <= 0){
                System.out.println("票已售空");
                break;
            }

            //休眠一秒，放大超卖现象的可能性及危险性
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"成功售出一张票，当前票剩余："+(--ticket));

        }
    }
}