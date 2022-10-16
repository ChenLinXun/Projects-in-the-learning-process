package BlockingQueue_;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
/*
 * 阻塞队列：
 * 概述：
 * 阻塞队列是一个共享的队列，使得数据由队列的一端输入，另一端输出
 * 线程能从队列中添加元素和取出元素，阻塞队列实现了生存者-消费者模型
 * 当队列为空的时候，向队列取元素的线程会被阻塞；
 * 当队列为满的时候，向队列添元素的线程会被阻塞。
 *
 * 三个常用的BlockingQueue接口实现类：
 * 1. ArrayBlockingQueue：
 *    基于数组的阻塞队列实现，内部维护了一个定长数组，以便缓存队列中的数据对象，
 *    除了一个定长数组外，内部还保存着两个整形变量，分别标识着队列的头部和尾部在数组中的位置
 *
 * 2. LinkedBlockingQueue：
 *    基于链表的阻塞队列，内部维护着一个链表，以便缓存队列中的数据对象，构造时传入链表长度限制
 *    如果构造时，没有指定其容量大小，会默认一个类似无限大小的容量（Integer.MAX_VALUE），
 *    这样的话，如果生产者的速度一旦大于消费者的速度，也许还没有等到队列满阻塞产生，
 *    系统内存就有可能已被消耗殆尽了。
 *
 * 3. SynchronousQueue：
 *    不存储元素的阻塞队列，放一个取一个，取一个放一个，生产者和消费者同步进行操作
 *
 * 四组核心方法：
 * 方法类型     抛出异常         返回特殊值       阻塞线程       超时（阻塞一段时间，超时后退出）
 *  插入        add(e)          offer(e)        put(e)        offer(e,time,unit)
 *  移除        remove()        poll()          take()        poll(time,unit)
 *  检查        element()       peek()          无            无
 */
public class BlockingQueue01 {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        //核心方法使用

        //1.返回特殊值
        //插入，成功返回true失败返回false
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d"));//false
        //移除，成功返回元素，失败返回null
        for (int i = 0; i < 3; i++) {
            blockingQueue.poll();
        }
        System.out.println(blockingQueue.poll());//null
        //检查，检查第一个元素，如果不为空返回第一个元素，为空返回null
        System.out.println(blockingQueue.peek());//null

        //2.超时，阻塞一段时间，超时后退出
        System.out.println(blockingQueue.offer("A"));
        System.out.println(blockingQueue.offer("B"));
        System.out.println(blockingQueue.offer("C"));
        System.out.println(blockingQueue.offer("D", 3L, TimeUnit.SECONDS));//3秒后返回false

    }
}
