package OOP.polymorphic;

/*
 * 多态的向上转型的本质：
 * 父类的引用类型指向子类对象（即声明的是父类，实际指向的是子类的一个对象。）  
 * Father f1 = new Son();表示定义了一个Father类型的引用，指向新建的Son类型的对象
 * 在JVM内存中：多态就是栈中的一个父类引用指向了堆中的实际的子类对象，
 * 也就是说，这个实际的子类对象可以被多个父类指向
 */

/*
 * Java动态绑定机制：
 *    1.当调用对象方法时，该方法会和该对象的内存地址/运行类型进行绑定
 *    2.当调用对象属性时，没有动态绑定机制，哪里声明，哪里使用
 */

/*
 * 使用细节：
 * 1.属性没有多态，没有重写之说，属性的值看编译类型
 * 2.等号左边是编译类型，等号右边是运行类型   换言之，等号左边的是一个引用类型，指向的是等号右边的实际对象
 * 3.当父类的引用调用方法时，必须执行Java动态绑定机制，
 *   也就是说：当调用一个父类的引用的方法时，所调用的一定是此引用指向的实际对象的方法，这个方法若是重写了，
 *   那么运行重写后的这个方法，如果没有重写，那么使用继承下来的这个方法； 
 *   注意！属性并不会与实际对象绑定，方法中所调用到的属性，在哪声明就在哪调用， 
 *   比如调用了一个没有重写的方法时，进入到了父类里使用继承的方法，那么这个方法调用的属性就是父类的属性；
 *   如果这个方法子类重写了，那么进入子类调用重写的方法，  这个方法调用的属性就是子类的属性
 */

public class PolymorphicTheory_up {

    public static void main(String[] args) {

        Son son = new Son();

        //多态就是栈中的一个父类引用指向了堆中的实际的子类对象，也就是说，这个实际的子类对象可以被多个父类指向
        Father father = son;
        Father father1 = son;

        //属性没有多态，没有重写之说，属性的值看编译类型
        System.out.println(father.name);//大头爸爸
        System.out.println(father.age);//39
        //当该编译类型没有此属性则向父类中寻找
        System.out.println(father.hobby);//旅游
        System.out.println("================================");

        //当调用方法时，执行动态绑定机制，也就是执行实际运行类型的方法
        father.move();
        //当调用实际类型中的这个方法没有重写时，自然调用继承下来的这个方法，
        // 注意！若方法中对属性进行了调用，属性在哪里声明就在哪里调用
        father.say();
        //方法中调用了一个方法，也要按照动态绑定机制，优先调用实际类型的方法
        father.test();

        System.out.println("================================");
        GrandPa grandPa = new Son();
        //father和son指向的是同一个实际对象，返回真
        System.out.println(father.equals(father1));
        //father和grandpa指向的不是同一个实际对象，返回假
        System.out.println(father.equals(grandPa));
    }

}

class GrandPa{

    String name = "大头爷爷";
    String hobby = "旅游";
    int age = 70;

    public void say(){
        System.out.println("我是"+name);
    }

    public void move(){
        System.out.println("我走得很慢");
    }

    public void test(){
        move();
    }
}

class Father extends GrandPa {

    String name = "大头爸爸";
    int age =39;

}

class Son extends Father {

    String name = "小头儿子";

    public void move(){
        System.out.println("我是"+name+"我走得很快");
    }

}



