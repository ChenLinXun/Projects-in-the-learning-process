package OOP.interface_;

/*
 * 接口多态参数的使用：
 * 接口的引用可以指向这个类的实例（向上转型），也可以将引用强转回实现类的引用（向下转型）
 */

public class Interface_Poly_Use {

    public static void main(String[] args) {

        Computer computer = new Computer();
        Iphone iphone = new Iphone();
        IPad iPad = new IPad();
        computer.connectEquipment(iphone);
        computer.connectEquipment(iPad);

    }

}

//定义一个UseB接口，所有连接电脑的设备都必须实现这个接口
interface UseB{

    void connect();

}

class Computer{

    //电脑连接设备的方法
    public void connectEquipment(UseB useB){//向上转型，接口引用useB指向了实现类

        //下面强行演示了向下转型，其实写一句useB.connect();效果是一样的
        if(useB instanceof Iphone){
            Iphone iphone = (Iphone) useB;//向下转型，接口引用useB强转回了实现类的引用
            iphone.connect();//调用实现类的方法
        }
        if(useB instanceof IPad){
            IPad iPad = (IPad) useB;
            iPad.connect();
        }

    }

}

//Iphone实现了UseB接口
class Iphone implements UseB{

    @Override
    public void connect() {
        System.out.println("iphone 13连接了电脑");
    }
}

//IPad实现了UseB接口
class IPad implements UseB{

    @Override
    public void connect() {
        System.out.println("iPad2021 连接了电脑");
    }
}