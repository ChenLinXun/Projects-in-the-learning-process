package OOP.innerClass_.localInnerClass_;
/*
 * 匿名内部类的一种使用场景：
 * 若一个方法需要传入的参数是接口类型的，当需要调用这个方法时，
 * 按传统方式要实现这个接口建立实例，然后把这个实例的引用作为参数传入方法中，不够简洁高效
 * 那么可以直接在调用这个方法时，在参数列表处直接实现这个接口获得匿名内部类的对象引用
 *
 */
public class Anonymous_application {

    public static void main(String[] args) {

        Iphone iphone = new Iphone();

        //ConnectComputer方法需要传入一个接口类型
        //可以不用创建接口实现类实例引用传入
        //而是直接在参数列表里面创建
        iphone.ConnectComputer(new UseB() {
            @Override
            public void connectComputer() {
                System.out.println("iphone连接了电脑");
            }
        });

    }
}

interface UseB{
    void connectComputer();
}

class Iphone{
    //假如有一个以接口类型作为参数的方法
    public void ConnectComputer(UseB useB){
        useB.connectComputer();
    }
}