package OOP.abstract_;

/*
 * 设计模式：模板模式（利用abstract修饰符，简单使用模板模式）
 *
 * 解释：
 * 当多个类（需求）既有自己各自的功能，又都有需要一个相同的功能（比如计算某个方法工作的时间）时，
 * 为了不在各个类中重复地实现这个相同的功能
 * 可以参照（继承）一个模板类（抽象类），这个模板中已经包含了各个类都相同的方法，不需要重写
 * 又包含了抽象方法，供各个不同的类来实现，这个方法也就是各个类各自的功能
 *
 * 设计方法：
 * 创建一个抽象类，设置抽象类中的公共方法，子类都继承且无需重写（子类相同的功能）
 * 设置抽象方法，子类都要实现，实现各自的功能
 *
 * 以下代码思考：
 * 加入没有Template这个模板类，那么累加类和类乘类就要各自写一个workTime方法，并且代码内容是完全一样的
 * 代码重复性高，效率低，加入了Template这个类后，workTime方法不需要子类再写，只需要重写job方法完成各自工作即可
 * 其实把Template类和job方法设置成普通方法，也可以达到效果,但是父类的job方法其实不需要实现，所以设置成抽象的更好
 *
 */

public class Template_Mode {

    public static void main(String[] args) {

        //这里设置了两个模板，一个模板用于累加功能，另一个用于累乘功能
        Template a = new AddCalculation();
        Template b = new MultiplyCalculation();

        a.workTime();
        b.workTime();
    }

}

abstract class Template{

    //类的工作
    public abstract void job();

    //类工作所用的时间
    public void workTime(){

        long start = System.currentTimeMillis();
        job();//这里执行了动态绑定机制，运行的job方法是和实际对象绑定的job方法
        long end = System.currentTimeMillis();

        System.out.println("工作用时为："+(end - start)+"ms");
    }

}

//执行累加工作的类
class AddCalculation extends Template{

    //累加工作
    @Override
    public void job() {
        int num = 0;
        for (int i = 0; i < 800000; i++) {
            num += i;
        }
        System.out.println("累加类完成了累加工作");
    }

}

//执行累乘工作的类
class MultiplyCalculation extends Template{

    //累乘工作
    @Override
    public void job() {
        int num = 0;
        for (int i = 0; i < 800000; i++) {
            num *= i;
        }
        System.out.println("累乘类完成了累乘工作");
    }

}