package OOP.innerClass_.localInnerClass_;
/*
 * 匿名内部类的本质：
 * 使用匿名内部类时，在语法上没有写实现类的名字，所以称它为匿名的，
 * 但实际上系统在底层自动创建它时当然会分配一个名字给它，
 * 它的名字是：外部类名$1 
 * （如果再写一个匿名内部类，那么这个匿名内部类被分配的名字就是：外部类名$2 ，以此类推）
 * 它使用一次就消失了，所以不能new 外部类名$1 ()
 *
 */

/*
 * 语法：参考以下代码即可
 */

/*
 * 使用细节和注意事项：
 * 1. 在语法的大括号后面直接点调用方法出来，相当于没有用一个引用来接收这个对象
 * 2. 若使用了这个接口或者抽象类的引用来接受这个对象， 
 *    那么此处相当于一个向上转型，因为接口和抽象类相当于 
 *    实现类的父类，那么就产生了父类的引用指向子类的对象
 * 3. 在调用方法时会使用动态绑定机制，调用的是对象的实际 
 *    类型的方法，也就是实现类（实现后）的方法
 * 4. 只有在用引用接收了这个对象之后，才可以用final修饰这个引用 
 *    因为"new 接口()"相当于一个对象，不是引用类型，没有声明，不能被修饰
 * 5. 其他的细节和注意事项和局部内部类一致
 *
 */
public class AnonymousInnerClass {

    public static void main(String[] args) {

        System.out.println("=======================");

        //系统底层自动创建了匿名内部类，实现了接口Animal，并返回了这个类的对象，被接口引用dog接收
        //把"new Animal()"看成返回的匿名内部类对象，此处相当于一个向上转型
        Animal dog = new Animal(){
            @Override
            public void cry(){
                System.out.println("小狗汪汪叫");
            }
        };
        dog.cry();
        System.out.println("这只小狗的类名是："+dog.getClass());
        //小狗的类是Animal的实现类，也就是其子类，所以是true
        System.out.println("小狗Animal是类吗："+(dog instanceof Animal));
        System.out.println(" ");


        Animal cat = new Animal() {
            @Override
            public void cry() {
                System.out.println("小猫喵喵叫");
            }
        };
        cat.cry();
        System.out.println("这只小猫的类名是："+cat.getClass());
        //小猫和小狗是两个类的实例，当然不是同一个对象
        System.out.println("小猫和小狗是同一个对象吗："+(dog == cat));
        System.out.println(" ");


        //系统底层自动创建了匿名内部类，继承了抽象类Hero，并返回了这个类的对象，被抽象类引用jieNuoSi接收
        //把"new Hero()"看成返回的匿名内部类对象，此处相当于一个向上转型
        final Hero jieNuoSi = new Hero(){//可以用final修饰jieNuoSi这个引用类型
            @Override
            public void showPower() {
                System.out.println("S级英雄杰诺斯：机关枪拳！");
            }
        };
        jieNuoSi.showPower();
        System.out.println("杰诺斯的类名是："+jieNuoSi.getClass());
        System.out.println(" ");

        //系统底层自动创建了匿名内部类，继承了抽象类Hero，并返回了这个类的对象
        //此处没有引用接受这个对象，直接使用这个对象调用方法
        new Hero(){//这里不能在new前面加final修饰，因为这是一个对象，不是引用类型，没有声明
            @Override
            public void showPower() {
                System.out.println("S级英雄邦古：流水岩碎拳！");
            }
        }.showPower();
        System.out.println("=======================");

        //对一个普通类也可以使用匿名内部类，随便写一下了
        xx x = new xx(){
            @Override
            public void yy() {
                System.out.println("hehe");
            }
        };
        x.yy();
        System.out.println(x.getClass());

    }

}

interface Animal{
    void cry();
}

abstract class Hero{
    public abstract void showPower();
}

class xx{
    public void yy(){

    }
}