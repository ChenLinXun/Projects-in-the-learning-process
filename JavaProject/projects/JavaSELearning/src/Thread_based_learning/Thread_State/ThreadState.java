package Thread_based_learning.Thread_State;
/*
 * 线程七大状态：
 * New（新建）、Runnable（可运行）、Blocked（阻塞）、Waiting（无限期等待）、
 * Time_Waiting（规定时间等待）、Terminated（死亡）
 * 其中Runnable状态可细分为：Ready（就绪）、Running（正在执行）两个状态，
 * 在Runnable状态中的线程处于操作系统内核态，此时线程是否运行由操作系统调度决定
 */
public class ThreadState {

    public static void main(String[] args) throws InterruptedException {

        T t = new T();
        System.out.println(t.getName() + "状态：" + t.getState());//New新建状态

        t.start();//启动线程，进入Runnable状态

        //输出子线程还未死亡时的状态
        while (Thread.State.TERMINATED != t.getState()){
            System.out.println(t.getName() + "状态：" + t.getState());
            Thread.sleep(1000);//主线程隔一秒输出一次子线程状态
        }

        //输出子线程死亡后的状态
        System.out.println(t.getName() + "状态：" + t.getState());

    }

}

class T extends Thread{

    @Override
    public void run() {
        while (true){
            for (int i = 0; i < 10 ; i++) {
                System.out.println("hi "+ i);
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