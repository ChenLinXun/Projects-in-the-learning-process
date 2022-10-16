package ThreadPool_;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/*
 * ThreadPoolExecutor七大参数解释：
 * 构造器源码：
 * public ThreadPoolExecutor(int corePoolSize,
 *                            int maximumPoolSize,
 *                            long keepAliveTime,
 *                            TimeUnit unit,
 *                            BlockingQueue<Runnable> workQueue,
 *                            ThreadFactory threadFactory,
 *                            RejectedExecutionHandler handler){}
 *
 * 1.  int corePoolSize：线程池中的核心（常驻）线程数量，也就是线程池中一直存在的线程
 * 2.  int maximumPoolSize：最大线程数量，线程池中能拓展到的最大线程数量
 * 3.  long keepAliveTime：非核心线程存在的时间
 * 4.  TimeUnit unit：非核心线程存在的时间单位
 * 5.  BlockingQueue<Runnable> workQueue：阻塞队列，核心线程都在处理请求时，新的请求所处的阻塞队列
 * 6.  ThreadFactory threadFactory：线程工厂，用于创建线程
 * 7.  RejectedExecutionHandler handler：拒绝策略，线程池繁忙时拒绝请求的策略
 *
 * ThreadPoolExecutor工作流程：
 * 1. 调用execute()时，才会在线程池中创建线程;
 * 2. 当请求数大于池中核心线程时，后来的请求会放置于阻塞队列中，等核心线程处理请求完毕后，阻塞队列中的请求
 *    会进入核心线程进行处理；
 * 3. 当核心线程已经在处理请求，而阻塞队列满了之后，再来请求时，会在池中开辟新的线程，直接处理这些请求；
 * 4. 当池中线程已创建至规定的最大线程数量，并且所有线程都在处理请求，并且阻塞队列也满了之后，
 *    若再来请求，会启动拒绝策略，对再来的请求进行拒绝处理
 *
 * 4种基本拒绝策略的解释：
 * 1. AbortPolicy：默认方式，直接抛出RejectedExecutionException异常，组织系统正常运行
 *
 * 2. CallerRunsPolicy：调用者模式，一种调节机制，该策略既不会抛弃任务，也不会抛出异常，
 *    而是将某些任务回退到调用者，从而降低新任务的流量。
 *
 * 3. DiscardOldestPolicy：抛弃阻塞队列中等待最久的任务，然后将请求加入到阻塞队列中，尝试取得处理
 *
 * 4. DiscardPolicy：该策略默默丢弃无法处理的请求，不作任何处理也不抛出异常，如果允许请求丢失，这是最好的策略
 *
 */
public class ThreadPoolExecutor_ {

    public static void main(String[] args) {

        //自定义创建线程池：
        //其中拒绝策略为：超出处理范围的请求直接抛出异常
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(2,5,3L,
                        TimeUnit.SECONDS, new ArrayBlockingQueue<>(3),
                        Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        //可能会抛出RejectedExecutionException异常，因为可能出现拒绝请求情况
        try {
            for (int i = 0; i < 10; i++) {
                threadPoolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"：处理业务");
                });
            }
        } finally {
            threadPoolExecutor.shutdown();
        }
        
    }

}
