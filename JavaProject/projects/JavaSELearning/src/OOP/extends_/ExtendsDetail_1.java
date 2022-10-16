package OOP.extends_;

//继承使用细节1：子类必须调用父类的构造器，完成父类的初始化

public class ExtendsDetail_1 {

    public static void main(String[] args) {
        new son0();
        System.out.println("==================");
        new son0(10);
    }

}

class Father0 {

    public Father0() {
        System.out.println("已完成父类father的初始化...");
    }
}

class son0 extends Father0{

    public son0() {
        System.out.println("成功创建子类son对象...");
    }

    public son0(int i) {
        System.out.println("成功创建"+i+"个子类son对象...");
    }

}