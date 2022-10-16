package Thread_communication.Custom_communication;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
 * 实现线程间通信同步（定制通信）：
 * A线程执行后，通知B线程执行-->B线程执行后，通知C线程执行-->C线程执行
 *
 * 实现方法二：
 * 使用Condition监视器，精准通知
 */
public class Custom_communication02 {

    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //获取服务类对象（线程资源对象）
        Server2 server = new Server2();

        //创建线程（乱序）
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                server.pay(i);//十次支付操作
            }
        },"B线程").start();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                server.submit(i);//十次提交操作
            }
        },"A线程").start();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                server.finish(i);//十次完成订单操作
            }
        },"C线程").start();

    }
}

class Server2{

    private int flag = 1;//代表应该到哪个线程执行

    private Lock lock = new ReentrantLock();

    //创建三个监视器，分别监视调用三个方法的线程
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void submit(int i){

        lock.lock();

        try {

            //判断
            while (flag != 1){
                try {
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //干活
            System.out.println(Thread.currentThread().getName()+"进行提交订单操作"+i);

            //更改标志位并唤醒执行pay()的线程
            flag = 2;
            condition2.signal();

        } finally {
            lock.unlock();
        }
    }

    public void pay(int i){

        lock.lock();

        try {

            //判断
            while (flag != 2){
                try {
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //干活
            System.out.println(Thread.currentThread().getName()+"进行支付操作"+i);

            //更改标志位并唤醒执行finish()的线程
            flag = 3;
            condition3.signal();

        } finally {
            lock.unlock();
        }
    }

    public void finish(int i){

        lock.lock();

        try {

            //判断
            while (flag != 3){
                try {
                    condition3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //干活
            System.out.println(Thread.currentThread().getName()+"完成订单操作"+i);

            //更改标志位并唤醒执行submit()的线程
            flag = 1;
            condition1.signal();

        } finally {
            lock.unlock();
        }
    }

}
