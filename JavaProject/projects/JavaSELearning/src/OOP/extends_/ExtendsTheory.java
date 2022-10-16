package OOP.extends_;

/*
 * 继承的本质：
 * 访问子类属性（方法）的规则--->按照查找关系来返回信息：
 * （1）首先看子类是否有该属性（方法）
 * （2）如果子类有，并且可以访问，则返回该信息（调用此方法）
 * （3）如果子类没有，则看其父类有没有，如果有，并且可以访问，则返回该信息（调用此方法）
 * （4）如果父类没有，则按照（3）的规则继续向上级父类寻找，直到找到Object
*/

/*
 * Java动态绑定机制：
 *    1.当调用对象方法时，该方法会和该对象的内存地址/运行类型进行绑定
 *    2.当调用对象属性时，没有动态绑定机制，哪里声明，哪里使用
 */

public class ExtendsTheory {

    public static void main(String[] args) {
        Son son = new Son();

        //调用对象的属性，若子类没有这个属性则向上级父类寻找
        System.out.println(son.name);
        System.out.println(son.age);
        System.out.println(son.hobby);
        System.out.println("==================");

        //调用子类重写后的方法
        son.move();
        //若子类没有重写该方法则向上级父类寻找
        //方法中所调用到的属性，在哪里声明的就在哪里使用
        son.say();
        son.test();
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

class Father extends GrandPa{

    String name = "大头爸爸";
    int age =39;

}

class Son extends Father{

    String name = "小头儿子";

    public void move(){
        System.out.println("我是"+name+"我走得很快");
    }

}