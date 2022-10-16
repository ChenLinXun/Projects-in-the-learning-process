package Thread_communication.Non_custom_communication;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/*
 * 线程间通信（非定制），实现同步：
 * 实现步骤：
 * 第一步：创建资源类，在资源类创建属性和操作方法
 * 第二步：在资源类操作方法：
 *       （1）判断->不能执行该操作则等待，释放锁(这里应该是循环判断，防止虚假唤醒)
 *       （2）干活->通过判断则进行操作
 *       （3）通知->操作结束唤醒其他线程，也就是通知其他线程干活
 * 第三步：创建多个线程调用资源类的操作方法
 *
 * 以下使用Lock接口实现类，实现线程间通信同步
 * 创建资源类，两个线程对资源类属性number进行加1、减1操作，并且只有number等于0时才加1，等于1时才减1，
 * 因此两个线程间需要进行通信，从而实现同步
 */
public class Communication02 {

    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //创建资源对象
        Share2 share = new Share2();

        //创建对资源对象加1操作线程
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A线程").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C线程").start();

        //创建对资源对象减1操作线程
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.reduce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B线程").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.reduce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D线程").start();
    }

}

//创建资源类
class Share2{

    //资源属性，规定该属性只能变1或变0
    private int number = 0;

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    //资源加1方法
    public void increase() throws InterruptedException {

        lock.lock();
        try {

            while (number != 0){
                condition.await();
            }

            //干活
            number++;
            System.out.println(Thread.currentThread().getName()+"完成加1，当前number值为："+number);

            //通知
            condition.signalAll();

        } finally {
            lock.unlock();
        }

    }

    //资源减1方法
    public void reduce() throws InterruptedException {

        lock.lock();
        try {

            //循环判断
            while (number != 1){
                condition.await();
            }

            //干活
            number--;
            System.out.println(Thread.currentThread().getName()+"完成减1，当前number值为："+number);

            //通知
            condition.signalAll();

        } finally {
            lock.unlock();
        }

    }

}