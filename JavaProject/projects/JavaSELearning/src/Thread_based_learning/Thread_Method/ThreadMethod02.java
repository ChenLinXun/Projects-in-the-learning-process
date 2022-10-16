package Thread_based_learning.Thread_Method;
/*
 * 第二组：
 * 1.  yield：线程的礼让。 
 *     让出cpu，让其他线程执行，但礼让的时间不确定，因为cpu资源可能不紧张，所以也不一定礼让成功
 * 2.  join：线程的插队。 
 *     插队的线程一旦插队成功，则肯定先执行完插入的线程所有的任务  
 */
public class ThreadMethod02 {

    public static void main(String[] args) throws InterruptedException {

        T2 t2 = new T2();
        t2.start();

        for (int i = 1; i <= 20; i++) {
            Thread.sleep(1000);
            System.out.println("主线程（小弟）吃了 "+i+" 个包子~~~");
            if(i == 5){
                System.out.println("主线程（小弟）让子线程（老大）先吃");
                //子线程插队
                t2.join();
                //如果是主线程礼让，礼让不一定成功
                //Thread.yield();
                System.out.println("子线程（老大）吃完了，主线程（小弟）接着吃");
            }
        }

    }
}

class T2 extends Thread{

    @Override
    public void run() {

        while (true){

            //子线程吃20个包子
            for (int i = 1; i <= 20; i++) {
                System.out.println("子线程（老大）吃了 "+i+" 个包子~~~");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            break;
        }
    }
}