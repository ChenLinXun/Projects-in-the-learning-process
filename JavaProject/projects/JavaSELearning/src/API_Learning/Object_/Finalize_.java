package API_Learning.Object_;
/*
 * 1.当对象被回收时，系统自动调用该对象的finalize方法。子类可以重写finalize方法做一些释放资源的操作
 * 2.什么时候被回收：当某个对象没有任何引用时，则jvm就会认为这个对象是个垃圾对象，就会使用垃圾回收机制
     来销毁该对象，在销毁之前会调用finalize方法
 * 3.垃圾回收机制的调用是由系统来决定的（即有自己的GC算法），也可以通过System.gc() 来主动触发垃圾回收机制
 *  （提示：实际开发中几乎不会运用finalize方法，最多只是应付面试）
 */
public class Finalize_ {

    public static void main(String[] args) {

        Car car = new Car("宝马");

        //让这个引用指向空
        car = null;
        //此时new的这个Car对象没有了任何引用，变成了个垃圾对象
        //系统若调用垃圾回收机制，将在销毁这个对象前调用finalize方法
        //但是注意，并不是某个对象一将变成垃圾，系统就会调用垃圾回收机制销毁它，而是有自己的GC算法

        System.gc();//可以主动调用垃圾回收机制，但是程序并不会阻塞在这里，执行完这句话后就会往下走

        System.out.println("程序退出了......");
    }

}

class Car{
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("我们销毁了汽车："+name);
        System.out.println("释放了某些资源......");
    }
}