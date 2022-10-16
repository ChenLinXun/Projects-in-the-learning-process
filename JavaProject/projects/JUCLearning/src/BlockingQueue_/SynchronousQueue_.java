package BlockingQueue_;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueue_ {

    @SuppressWarnings({"all"})
    public static void main(String[] args){

        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println(Thread.currentThread().getName()+"放入一个包子");
                    blockingQueue.put("包子");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"生产者线程").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    blockingQueue.take();
                    System.out.println(Thread.currentThread().getName()+"拿走了一个包子");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"消费者线程").start();

    }
}
