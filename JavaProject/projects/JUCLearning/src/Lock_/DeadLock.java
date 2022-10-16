package Lock_;
/*
 * 验证是否死锁的方法：
 * 1. 使用当前java进程查看工具：jps，启动进程后在控制台输入jps -l命令，定位进程号
 * 2. 使用堆栈跟踪工具：jstack，输入jps -l命令后，输入jstack 进程号 命令，查看是否死锁
 */
public class DeadLock {

    public static void main(String[] args){

        UnreasonableSource source = new UnreasonableSource();

        new Thread(()->{source.get1();},"A线程").start();
        new Thread(()->{source.get2();},"B线程").start();
    }

}

//不合理的资源类，该类的同步方法可能造成死锁
class UnreasonableSource{

    Object o1 = new Object();
    Object o2 = new Object();

    public void get1(){
        synchronized (o1){
            System.out.println(Thread.currentThread().getName()+"获取资源o1");
            try {
                Thread.sleep(1000);//放大出现死锁的可能
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2){
                System.out.println(Thread.currentThread().getName()+"获取资源o2");
            }
        }
    }

    public void get2(){
        synchronized (o2){
            System.out.println(Thread.currentThread().getName()+"获取资源o2");
            try {
                Thread.sleep(1000);//放大出现死锁的可能
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1){
                System.out.println(Thread.currentThread().getName()+"获取资源o1");
            }
        }
    }

}