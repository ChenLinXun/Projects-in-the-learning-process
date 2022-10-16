package OOP.static_;
/*
 * 设计模式：单例模式（利用static修饰符，简单使用单例模式）
 * 单例模式---懒汉式：
 * 解释：
 * 单例模式是指希望某一个类最多只能有一个对象，不允许创建更多的对象
 * 懒汉式是指，当类被加载时（比如调用了类的静态属性或方法）这个对象不会被创建，而是在调用获取对象的方法时才创建
 * 设计方法：
 * 1.将构造器设置为private的，不允许直接new一个对象
 * 2.在类中创建这个类的静态对象的引用但不赋值
 * 3.设置一个静态方法，做一个判断：当这个类对象为空时，创建这个唯一的对象(给引用赋值)，判断之外返回这个引用
 *
 * 优点：类加载不会导致对象的创建，只有在调用获取对象的方法时创建，避免了资源浪费
 * 缺点：懒汉式是线程不安全的，在获取对象的方法处可能造成线程安全问题
 */
public class Singleton_Mode02 {

    public static void main(String[] args) {

        //懒汉式的优点：当仅是调用类的静态属性时不会创建类对象，不造成浪费
        System.out.println(Singleton2.n);
        System.out.println("====================");

        //只能创建一个对象
        Singleton2 singleton = Singleton2.getSingleton();
        Singleton2 singleton1 = Singleton2.getSingleton();
        System.out.println("singleton 和 singleton01指向的是同一个对象："+(singleton == singleton1));

    }

}

class Singleton2 {

    public static int n;
    private static Singleton2 singleton;

    private Singleton2() {
        System.out.println("调用了Singleton构造器");
    }

    public static Singleton2 getSingleton() {

        //懒汉式缺点：这里是线程不安全的，可能多个进程进入同时创建了多个对象
        if(singleton == null){
            singleton = new Singleton2();
        }

        return singleton;

    }
}
