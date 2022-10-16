package Thread_communication.Facke_WakeUp;
/*
 * 一：
 * 发生虚假唤醒现象的原因：
 * 资源判断是if判断，那么一些线程唤醒后，即使不符合条件，也可以向下执行，对资源进行操作，因为wait()方法
 * 在哪睡眠，就在哪唤醒，也就是继续执行下面的代码。
 * 例如：
 * Share类资源方法中的当前number值判断使用的是if判断，一些线程在唤醒后没有再次判断number值就往下执行，
 * 则可能造成资源数据的错误操作
 *
 * 二：
 * 具体解释：
 * 1.当只有两个线程AB，分别做减一和加一操作时，不管进入资源操作方法（拿到锁）的是哪个线程，
 *   另一个线程一定是做相反的操作，也就是说加1后，必定减1；减1后，必定加1；因此即使其中一个线程从等待
 *   状态中被唤醒时，即使没有再做number的判断，也不会影响该逻辑的执行
 *
 * 2.而当线程超过两个时，必定会有一个以上的线程做的是相同的操作，比如，AC线程都做加1操作；那么很可能会
 *   出现这样的虚假唤醒现象：假如C线程因为判断不通过正在睡眠，当前number值变为了0；A线程也是做加1操作
 *   的，此时抢到了锁，于是A通过判断，对number进行加1，并且唤醒了其他线程；这时，就变得很危险了，
 *   如果现在C抢到了锁，C在睡眠前已经做了if判断了，所以现在不再做判断，直接可以对number进行加1，
 *   那么number的值就变成了2，造成错误操作。出现了“加1后又加1”的情况。
 *   此时的C不应该通过判断，而应该继续睡眠，这是一个虚假的唤醒
 *
 * 三：
 * 解决虚假唤醒的方法：
 * 资源判断不用if判断，用循环判断，使唤醒后的线程仍需要判断是否符合操作条件
 *
 * 以下展示虚假唤醒的情况：
 */
public class Fake_wakeup {

    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //展示虚假唤醒情况：
        System.out.println("--------------虚假唤醒问题-----------------");

        //创建资源类对象，该资源类的资源判断是if判断，是不对的
        Share share = new Share();

        //创建线程，对资源类对象进行增加资源操作
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } ,"A线程").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } ,"C线程").start();

        //创建线程，对资源类对象进行减少资源操作
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.reduce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } ,"B线程").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.reduce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } ,"D线程").start();

    }
}

//资源类
class Share{

    //资源属性，规定该属性只能变1或变0
    private int number = 0;

    //资源方法，只有当number为0时才加1
    public synchronized void increase() throws InterruptedException {

        //判断（这里是if判断，可能造成虚假唤醒）
        if (number != 0){
            this.wait();//wait()方法释放锁
        }

        //干活
        number++;
        System.out.println(Thread.currentThread().getName()+"完成加1，当前number值为："+number);

        //通知
        this.notifyAll();
    }

    //资源方法，只有当number为1时才减1
    public synchronized void reduce() throws InterruptedException {

        //判断（这里是if判断，可能造成虚假唤醒）
        if (number != 1){
            this.wait();//wait()方法释放锁
        }

        //干活
        number--;
        System.out.println(Thread.currentThread().getName()+"完成减1，当前number值为："+number);

        //通知
        this.notifyAll();
    }

}
