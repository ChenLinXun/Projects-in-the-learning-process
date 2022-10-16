package OOP.static_;
/*
 * 设计模式：单例模式（利用static修饰符，简单使用单例模式）
 * 单例模式---饿汉式：
 * 解释：
 * 单例模式是指希望某一个类最多只能有一个对象，不允许创建更多的对象
 * 饿汉式是指，当类被加载时（比如调用了类的静态属性或方法）这个对象就随之被创建，不管之后程序是否使用到这个对象
 * 设计方法：
 * 1.将构造器设置为private的，不允许直接new一个对象
 * 2.在类中创建这个类的静态对象并赋值引用，获取这个对象一定是通过静态方法获取，所以对象也必须是静态的
 * 3.设置一个静态方法返回这个唯一的对象的引用，只能通过类名调用，所以方法必须是静态的
 *
 * 优点：饿汉式是线程安全的，不用考虑线程安全问题
 * 缺点：对象在类加载时被创建，可能造成资源浪费
 */
public class Singleton_Mode01 {

    public static void main(String[] args) {

        //饿汉式的缺点：当仅是调用类的静态属性时也创建了类对象，然而却有可能用不到，造成浪费
        System.out.println(Singleton1.n);
        System.out.println("====================");
        //只能创建一个对象
        Singleton1 singleton = Singleton1.getSingleton();
        Singleton1 singleton1 = Singleton1.getSingleton();
        System.out.println("singleton 和 singleton01指向的是同一个对象："+(singleton == singleton1));


    }

}

class Singleton1{

    public static int n;
    private static Singleton1 singleton = new Singleton1();

    private Singleton1(){
        System.out.println("调用了Singleton构造器");
    }

    public static Singleton1 getSingleton(){
        return singleton;
    }


}