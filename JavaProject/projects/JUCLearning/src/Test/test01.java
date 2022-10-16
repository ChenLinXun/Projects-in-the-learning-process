package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReadWriteLock;

public class test01 {

    public static void main(String[] args){

        Phone phone = new Phone();

        new Thread(()->{
            System.out.println("A线程执行了···");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            phone.change();
            System.out.println(Thread.currentThread().getName()+"把值更改了："+phone.num);

        },"A线程").start();

        while (phone.num == 0){}

    }
}

class Phone{

    //volatile int num = 0;
    int num = 0;

    public void change(){
        this.num = 60;
    }
}