package Thread_based_learning.Thread_DeadLock;
/*
 * 死锁：两个或两个以上的线程占有彼此需要的资源，同时又都不愿意释放已有资源，而形成的循环等待的局面
 */
public class DeadLock {

    //模拟死锁的发生
    public static void main(String[] args) {

        //创建两个DeadLockThread对象，他们一开始拿到的锁不同
        DeadLockThread dt1 = new DeadLockThread(true);
        DeadLockThread dt2 = new DeadLockThread(false);

        dt1.start();
        dt2.start();

    }
}

class DeadLockThread extends Thread{

    private boolean lock;

    //锁资源共享，所以设置为静态的
    private static Object obj1 = new Object();
    private static Object obj2 = new Object();

    public DeadLockThread(boolean lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        //如果lock为true，则走以下业务代码
        if(lock) {
            synchronized (obj1) {

                System.out.println(Thread.currentThread().getName()+"拿到资源锁obj1，等待obj2");

                synchronized (obj2) {
                    System.out.println("拿到两个资源锁，完成业务代码");
                }
            }
        } else {//否则走以下业务代码
            synchronized (obj2) {

                System.out.println(Thread.currentThread().getName()+"拿到资源锁obj2，等待obj1");

                synchronized (obj1) {
                    System.out.println("拿到两个资源锁，完成业务代码");
                }
            }
        }
    }
}