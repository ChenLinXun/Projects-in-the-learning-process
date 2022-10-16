package Thread_communication.Non_custom_communication;
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
 * 以下通过synchronized关键字，完成线程间通信同步：
 * 创建资源类，两个线程对资源类属性number进行加1、减1操作，并且只有number等于0时才加1，等于1时才减1，
 * 因此两个线程间需要进行通信，从而实现同步
 */
public class Communication01 {

    public static void main(String[] args) {

        //创建资源类对象
        Share1 share = new Share1();

        //创建线程，对资源类对象进行增加资源操作
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } ,"A线程").start();

        //创建线程，对资源类对象进行减少资源操作
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.reduce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } ,"B线程").start();
    }

}

//资源类
class Share1{

    //资源属性，规定该属性只能变1或变0
    private int number = 0;

    //资源方法，只有当number为0时才加1
    public synchronized void increase() throws InterruptedException {

        //循环判断
        while (number != 0){
            this.wait();//wait()方法释放锁
        }

        //干活
        number++;
        System.out.println(Thread.currentThread().getName()+"完成加1，当前number值为："+number);

        //通知
        this.notifyAll();
    }

    //资源方法，只有当number为1时才减1
    public synchronized void reduce() throws InterruptedException {

        //循环判断
        while (number != 1){
            this.wait();//wait()方法释放锁
        }

        //干活
        number--;
        System.out.println(Thread.currentThread().getName()+"完成减1，当前number值为："+number);

        //通知
        this.notifyAll();
    }

}