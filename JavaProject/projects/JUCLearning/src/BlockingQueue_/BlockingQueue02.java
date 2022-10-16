package BlockingQueue_;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/*
 * 使用阻塞队列，解决生产者消费者问题
 */
public class BlockingQueue02 {

    @SuppressWarnings({"all"})
    public static void main(String[] args){

        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(1);

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    blockingQueue.put("包子");
                    System.out.println(Thread.currentThread().getName()+"放入一个包子");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"生产者线程").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    blockingQueue.take();
                    System.out.println(Thread.currentThread().getName()+"拿走了一个包子");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"消费者线程").start();

    }

}
