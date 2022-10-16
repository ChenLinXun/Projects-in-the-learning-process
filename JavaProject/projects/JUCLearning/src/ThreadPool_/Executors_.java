package ThreadPool_;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
 * 创建三种线程池的方法：
 * 使用Executors工具类进行创建：
 * Executors.newSingleThreadExecutor()：创建只有一个线程的线程池
 * Executors.newFixedThreadPool(int)：创建指定线程数量的线程池
 * Executors.newCachedThreadPool()：创建线程数量可扩展的线程池（根据需求自动在池中创建线程）
 *
 * 使用Executors工具类进行线程池创建，底层都是在创建一个ThreadPoolExecutor线程池对象并返回
 *
 * 在实际开发中，Executors工具类创建线程有严重弊端，因为无法设定拒绝策略等ThreadPoolExecutor参数
 * 容易出现OOM等资源消耗问题，所以不会使用Executors工具类进行线程池创建，
 * 而是直接通过ThreadPoolExecutor的方式(根据业务，自己传入参数)创建线程池
 */
public class Executors_ {

    public static void main(String[] args) {

        //以下取消注释进行调试：

        //一池一线程
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();

        //一池五线程
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        //一池可扩展线程（根据情况，增加线程处理请求）
        //ExecutorService threadPool = Executors.newCachedThreadPool();

        //6条请求，根据线程池的选择进行处理
        try {
            for (int i = 0; i < 20; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"：处理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();//线程使用完毕，返还线程池
        }

    }

}
