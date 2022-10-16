package Thread_based_learning.Thread_End;
/*
 * 1.  当线程完成任务后，会自动退出
 * 2.  还可以通过使用变量来控制run方法退出的方式停止线程，即通知方式
 */
public class Thread_End {

    public static void main(String[] args) throws InterruptedException {

        Cat cat = new Cat();
        cat.start();

        //主线程先休眠5秒，让子线程执行5秒
        Thread.sleep(5 * 1000);
        //然后通知子线程终止
        System.out.println("主人：好了小猫，睡了睡了");
        cat.setLoop(false);

    }

}

class Cat extends Thread{

    private boolean loop = true;

    @Override
    public void run() {
        while (loop){
            System.out.println("小猫喵喵叫~~~");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("喵~~~~~~~~~");
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}