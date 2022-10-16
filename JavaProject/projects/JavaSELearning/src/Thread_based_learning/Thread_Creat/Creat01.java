package Thread_based_learning.Thread_Creat;
/*
 * 实现多线程的本质:
 * 1.  Thread类实现了Runnable接口，实现了接口中唯一的方法run()，该方法用于执行业务代码
 * 2.  Thread类对象调用start()方法，线程启动后，会调用run()方法，执行业务代码
 * 3.  真正实现多线程效果的并不是run()方法，run()方法实际就是一个普通方法，只是线程启动时会调用； 
 *     而真正实现多线程效果的是start0()方法，该方法是一个本地方法，由JVM调用，底层是C/C++实现,
 *     JVM通过调用start0()方法来调用run()方法
 * 4.  当start()方法调用start0()方法后，该线程不一定会马上创建，start0()是本地方法，
 *     创建线程的工作是交给操作系统完成的， 
 *     Java其实本质上不能创建线程，只是给操作系统发送指令，具体线程的创建是操作系统调度决定的  
 * 5.  start()方法在调用了start0()方法后，并且线程创建后，该线程不一定会马上执行，
 *     只是将线程变成可运行状态，具体什么时候运行该线程，要看CPU的调度，这是操作系统考虑的    
 *
 * 线程创建方法一：
 * 继承Thread类，重写run()方法：
 * 1.  Thread类实现了Runnable接口，实现了run()方法
 * 2.  当一个继承了Thread类，那么该类的对象就可以当做一个线程使用
 * 3.  我们会在该类的run()方法上，写自己的业务代码
 * 4.  调用该类对象的start()方法，启动线程，线程启动后JVM调用该线程的run()方法
 */
public class Creat01 {

    @SuppressWarnings({"all"})
    public static void main(String[] args) throws InterruptedException {

        //启动进程也就是运行代码时可以在控制台输入：JConsole，使用线程监控工具，查看线程的执行

        System.out.println("主线程启动，创建子线程");

        //ThreadCat类继承了Thread，创建一个ThreadCat对象，该对象即是一个线程
        ThreadCat cat1 = new ThreadCat();
        //启动线程
        cat1.start();

        //主线程的执行
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+" ：小狗汪汪叫"+i);
            Thread.sleep(1000);
        }

    }

}

@SuppressWarnings({"all"})
class ThreadCat extends Thread{

    //重写run()方法
    @Override
    public void run() {
        int count = 0;
        while (true){

            System.out.println(Thread.currentThread().getName()+" ：小猫喵喵叫"+(count++));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == 20){
                break;
            }
        }

    }
}