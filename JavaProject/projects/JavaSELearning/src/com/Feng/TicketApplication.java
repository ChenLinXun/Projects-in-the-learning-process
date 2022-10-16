package com.Feng;

public class TicketApplication {
    public static void main(String[] args) {
        //创建一个多线程买票类对象
        TicketThread ticket = new TicketThread();
        //创建三个线程（一个人就是一个线程）进行买票
        new Thread(ticket,"张一").start();
        new Thread(ticket,"张二").start();
        new Thread(ticket,"张三").start();
    }
}

class TicketThread implements Runnable {
    //定义总票数和卖出的第n张票数
    private int ticketNums = 10;
    boolean flag = true;

    @Override
    public void run() {
        while (flag){
            try{
                buy();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private synchronized void buy() throws InterruptedException {
        if(ticketNums<=0){
            flag = false;
            return;
        }

        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNums-- + "票");
        //Thread.currentThread().getName()方法获取线程名
    }
}