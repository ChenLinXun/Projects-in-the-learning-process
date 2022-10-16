package Tools;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/*
 * Semaphore：信号量
 * 创建Semaphore对象，传入信号量的值
 * 每个需要对信号量进行操作的线程，需要先对信号量减一，执行完毕后，对信号量进行加一
 * 调用semaphore.acquire()的线程如果此时信号量大于0，则对信号量减一，执行后面的代码，否则阻塞等待
 * 调用semaphore.release()的线程对信号量进行加1
 */
public class Semaphore_ {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();//信号量操作
                    System.out.println(Thread.currentThread().getName()+"抢到停车位");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName()+"离开停车位...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();//保证最后一定对信号量加1
                }
            },(i)+"号车").start();
        }

    }
}
