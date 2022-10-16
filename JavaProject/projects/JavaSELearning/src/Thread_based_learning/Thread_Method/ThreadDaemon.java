package Thread_based_learning.Thread_Method;
/*
 * 用户线程和守护线程
 * 1.  用户线程：也叫工作线程，当线程的任务执行完或通知方式结束
 * 2.  守护线程：一般是为工作线程服务的，当所有的用户线程结束，守护线程自动结束
 * 3.  常见的守护线程：垃圾回收机制
 *
 * 方法：
 * setDaemon()：设置线程为守护线程。
 */
public class ThreadDaemon {

    public static void main(String[] args) throws InterruptedException {

        DaemonThread dt = new DaemonThread();
        //设置守护线程
        dt.setDaemon(true);
        dt.start();

        //主线程执行业务
        for (int i = 0; i < 10; i++) {
            System.out.println("用户线程正在执行业务···");
            Thread.sleep(1000);
        }

        System.out.println("主线程业务执行结束");
    }

}

class DaemonThread extends Thread{

    @Override
    public void run() {
        for (;;){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("金山毒霸正持续为您护航~~~~~");
        }
    }
}