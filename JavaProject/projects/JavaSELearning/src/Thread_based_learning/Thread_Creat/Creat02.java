package Thread_based_learning.Thread_Creat;
/*
 * 线程创建方法二：
 * 实现Runnable接口，重写run()方法：
 * 1. 这是推荐的创建线程的方法，原因： 
 *    java是单继承的，在某些情况下一个类可能已经继承了某个父类,这时在用继承Thread类方法来创建线程显然不可能了。
 *    并且实现Runnable接口方式更加适合多个线程共享一个资源的情况
 * 2. 实现了Runnable接口的类，只是实现了run()方法，而并没有start()方法，实际上该类对象并不能真正地创建线程
 * 3. Thread类有一个构造方法，根据传入Runnable接口的实现类对象，创建一个Thread对象，并且在调用该Thread对象的
      run()方法时，调用的是传入的Runnable接口的实现类对象的run()方法，这里使用的是静态代理的设计模式
 * 4. 因此使用方法如下： 
 *    4.1  创建Runnable接口的实现类 
 *    4.2  创建该类对象 
 *    4.3  根据该对象创建Thread类对象 （静态代理） 
 *    4.4  根据该Thread类对象调用start()方法启动线程 （静态代理）
 */
public class Creat02 {

    @SuppressWarnings({"all"})
    public static void main(String[] args) throws InterruptedException {

        //启动进程也就是运行代码时可以在控制台输入：JConsole，使用线程监控工具，查看线程的执行

        System.out.println("主线程启动，创建子线程");

        //创建Runnable实现类对象
        ThreadSheep sheep1 = new ThreadSheep();

        //创建Thread类对象，为sheep1进行代理，如果此处创建多个线程，则它们都是共享同一个sheep1资源对象
        Thread threadSheep1 = new Thread(sheep1);

        //调用Thread类对象start()方法，调用sheep1的run()方法，进行代理
        threadSheep1.start();

        //主线程的执行
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName()+" ：小狗汪汪叫"+i);
            Thread.sleep(1000);
        }

    }

}

@SuppressWarnings({"all"})
class ThreadSheep implements Runnable{

    //重写Run方法
    @Override
    public void run() {
        int count = 0;
        while (true){

            System.out.println(Thread.currentThread().getName()+" ：小羊咩咩叫"+(count++));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == 60){
                break;
            }
        }
    }
}