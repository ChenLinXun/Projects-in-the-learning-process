package Callable_;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/*
 * 使用Callable接口创建线程：
 * Thread类只能通过Runnable接口实现类进行创建对象，因此不能直接通过Callable接口实现类进行创建
 * FutureTask类实现了Runnable接口，同时FutureTask可以根据传入Runnable实现类或Callable实现类进行创建
 * 因此，实现了Callable接口的类对象，通过构建FutureTask对象，来创建一个Thread线程
 * 当Thread对象调用run()方法时，会调用FutureTask的run()方法，
 * FutureTask的run()方法调用Callable的call()方法
 *
 * Callable接口和Runnable接口使用的不同：
 * 实现Callable接口的线程，可以在线程执行结束后返回一个值，Runnable接口不可以
 * 该值通过构建的FutureTask对象的get()方法获取
 */
public class CallableThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //Callable实现类对象，同时是资源类对象
        ShellTicket shellTicket = new ShellTicket();

        //创建三个FutureTask类对象，由同一个资源对象创建
        FutureTask<Integer> taskA = new FutureTask<>(shellTicket);
        FutureTask<Integer> taskB = new FutureTask<>(shellTicket);
        FutureTask<Integer> taskC = new FutureTask<>(shellTicket);

        //创建三个线程，对同一个资源类对象操作
        new Thread(taskA,"A线程").start();
        new Thread(taskB,"B线程").start();
        new Thread(taskC,"C线程").start();

        //主线程一边等待三个线程抢资源，一边干自己的事
        while (!(taskA.isDone() && taskB.isDone() && taskC.isDone())){
            //这里可以写主线程要干的事，什么都不写就是纯等待
        }
        //三个线程抢完后，主线程输出他们抢到的资源，进行汇总
        System.out.println("线程A抢到票数："+taskA.get());
        System.out.println("线程B抢到票数："+taskB.get());
        System.out.println("线程C抢到票数："+taskC.get());

    }

}
//Callable接口实现类
class ShellTicket implements Callable<Integer> {

    private int ticket = 100;

    public synchronized int sell(){
        if (ticket <= 0){
            return 0;
        }
        System.out.println(Thread.currentThread().getName()+"成功售出1张票，票余："+(--ticket));
        return 1;
    }

    @Override
    public Integer call(){
        int num = 0;//记录某个线程抢到的票数
        for (int i = 0; i < 40; i++) {
            num += sell();
        }
        return num;//返回某个线程抢到的票数
    }
}