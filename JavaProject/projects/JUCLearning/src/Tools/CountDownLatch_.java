package Tools;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/*
 * CountDownLatch：减少计数工具类（减法计数器）
 *
 * CountDownLatch类可以设置一个计数器，然后通过countDown()方法来进行减1的操作，
 * 使用await()方法等待计数器不大于0，然后继续执行await方法之后的语句。
 *
 * 执行await()方法的线程，会被阻塞在调用位置，当计数为小于等于0时，才被唤醒继续执行
 * 执行countDown()方法的线程会将计数减1
 * 使用CountDownLatch是为了保证某个线程必须先执行某些任务后，再执行await()后面的事情
 *
 */
public class CountDownLatch_ {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(6);

        System.out.println("所有子线程都执行完毕，主线程才继续执行...");

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"执行完毕");
                latch.countDown();
            },"线程"+(i)).start();
        }

        latch.await();//主线程等待计数归零

        System.out.println("子线程都完成任务，主线程开始执行其他事情...");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("主线程执行完毕");
    }

}
