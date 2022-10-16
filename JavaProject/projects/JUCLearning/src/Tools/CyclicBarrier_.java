package Tools;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
/*
 * CyclicBarrier：增加计数工具类（加法计数器）
 * 一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点(common barrier point)
 *
 * 创建cyclicBarrier对象时，传入一组线程的个数也就是屏障点，还可以选择传入一个线程（Runnable）
 * 当组中的一个线程调用后cyclicBarrier.await()方法后，计数器加1，并且该线程阻塞，等待组内其他线程执行
 * 当组内所有线程都调用cyclicBarrier.await()方法后，计数器值到达屏障点，
 * 组内所有线程开始执行await()后面的代码，如果cyclicBarrier对象传入了一个线程，此时执行该线程
 *
 */
public class CyclicBarrier_ {

    public static void main(String[] args) throws InterruptedException {

        //案例一：神龙等待召唤
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("7颗龙珠已集齐，召唤神龙！");
        });

        for (int i = 0; i < 7; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"集齐一棵龙珠");
                try {
                    cyclicBarrier.await();//集齐一颗后等待其他6个线程收集龙珠
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },"线程"+(i)).start();
        }

        TimeUnit.SECONDS.sleep(3);//主线程休息3秒再执行案例二，避免打印信息混乱

        //案例二：等待所有运动员都到起跑线，同时起跑
        CyclicBarrier cyclicBarrier1 = new CyclicBarrier(8);

        for (int i = 1; i <= 8; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"走到了起跑线");
                try {
                    cyclicBarrier1.await();//等待其他运动员走上起跑线
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"开始起跑");
            },(i)+"号运动员").start();
        }

    }
}
