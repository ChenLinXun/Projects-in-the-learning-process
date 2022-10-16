package Thread_communication.Custom_communication;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
 * 实现线程间通信同步（定制通信）：
 * A线程执行后，通知B线程执行-->B线程执行后，通知C线程执行-->C线程执行
 *
 * 实现方法一：
 * 设置标志位flag，通知所有线程
 */
public class Custom_communication01 {

    public static void main(String[] args) {

        //获取服务类对象（线程资源对象）
        Server server = new Server();

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

class Server{

    private int flag = 1;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void submit(int i){

        lock.lock();

        try {

            //判断
            while (flag != 1){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //干活
            System.out.println(Thread.currentThread().getName()+"进行提交订单操作"+i);

            //更改标志位并唤醒其他线程
            flag = 2;
            condition.signalAll();

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
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //干活
            System.out.println(Thread.currentThread().getName()+"进行支付操作"+i);

            //更改标志位并唤醒其他线程
            flag = 3;
            condition.signalAll();

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
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //干活
            System.out.println(Thread.currentThread().getName()+"完成订单操作"+i);

            //更改标志位并唤醒其他线程
            flag = 1;
            condition.signalAll();

        } finally {
            lock.unlock();
        }
    }

}