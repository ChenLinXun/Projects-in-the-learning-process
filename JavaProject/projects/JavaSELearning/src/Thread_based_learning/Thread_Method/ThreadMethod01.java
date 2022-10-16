package Thread_based_learning.Thread_Method;
/*
 * 第一组：
 * 1.  setName      //设置线程名称，使之与参数name相同
 * 2.  getName     //返回该线程的名称
 * 3.  start            //使该线程开始执行（Java虚拟机底层调用该线程的start0方法）
 * 4.  run             //调用线程对象run方法
 * 5.  setPriority  //更改线程的优先级
 * 6.  getPriority //获取线程的优先级
 * 7.  sleep       //在指定的毫秒数内让当前正在执行的线程休眠（暂停执行)
 * 8.  interrupt   //中断线程
 * 9.  currentThread   //获得当前线程的引用
 */
public class ThreadMethod01 {

    public static void main(String[] args) {

        T t = new T();
        Thread thread = new Thread(t);
        //设置线程名称
        thread.setName("陈林迅");
        //设置线程优先级
        thread.setPriority(Thread.MIN_PRIORITY);
        //获取线程优先级
        System.out.println(thread.getName()+"的线程优先级："+thread.getPriority());
        //启动线程
        thread.start();

        //主线程休息5秒钟，再中断线程thread，让其停止休眠继续吃包子
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //中断thread线程，主线程运行结束
        thread.interrupt();

    }
}

class T implements Runnable{

    @Override
    public void run() {

        int count = 0;//包子
        while (true){

            //该线程吃10个包子
            for (int i = 1; i <= 10 ; i++) {
                System.out.println(Thread.currentThread().getName()+" 正在吃包子~~~"+i);
                count++;
            }

            //吃完30个包子线程结束
            if (count == 30){
                System.out.println("30个包子吃完啦，溜了~~~");
                break;
            }

            System.out.println("吃完了，开始休息···");

            //吃完10个先休息10秒，再继续吃
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                //这里会捕获一个中断异常，当该线程被中断时会捕获该异常，在这里可以加入自己的业务代码
                //当捕获到该异常时，睡眠中断，try中语句不执行
                System.out.println(Thread.currentThread().getName()+"的休眠被中断了，那继续吃包子~~~");
            }

        }
    }
}