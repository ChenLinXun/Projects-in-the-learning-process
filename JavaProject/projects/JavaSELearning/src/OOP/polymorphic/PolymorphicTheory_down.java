package OOP.polymorphic;

/*
 * 多态的向下转型的本质：
 * 把一个指向子类对象的父类引用类型转换成了子类引用类型，Cat cat = (Cat)animal;
 * （也就是父类的引用变成了子类的引用，指向的还是原来的实际对象）

 * 在JVM内存中：多态向下转型就是：栈中一个指向子类对象的父类引用，
 * 转换出了一个所指向堆中这个实际对象类型的引用，原来的这个父类引用仍然指向该子类对象
 */

/*
 * 多态的向下转型使用细节：
 * 1.只能强转父类的引用，不能强转父类的对象（也就是指向堆中的实际对象是无法改变的）
 * 2.要求父类引用强制转换的目标子类引用必须是这个父类引用所指向对象的类型
 *  （也就是原本父类引用animal指向的是Cat类型对象，那么animal只能强转为Cat类型的引用）
 *  （比如这个animal不能强转为Dog引用类型，因为猫和狗都是动物的子类但是彼此没有任何关系）
 *  （这个animal也不能强转为Cat的子类类型，例如ChineseCat）
 *  （总之，原本这个父类引用指向哪个子类对象，那么向下转型时就只能强转哪个子类对象的引用类型）
 * 3.当向下转型后，可以调用子类类型的所有成员
 */


public class PolymorphicTheory_down {

    public static void main(String[] args) {

        //向上转型：父类引用指向子类对象
        Animal animal = new Dog();
        //向下转型：将这个父类引用强转为所指子类对象的子类引用类型
        Dog dog = (Dog)animal;
        System.out.println(dog.name);

        //这里是把指向Dog对象的animal父类引用转换成了Cat类型，是错误的，编译会报错
        //animal原本指向的是Dog类型对象，只能强转为Dog类型的引用类型
        Cat cat = (Cat)animal;

    }

}

class Animal{

    String name = "动物";
    String color = "白色";
    String food = "肉";

    public void say(){
        System.out.println("我是"+name);
    }

    public void move(){
        System.out.println("我跑得很慢");
    }

    public void test(){
        move();
    }
}

class Dog extends Animal{

    String name = "大黄";
    String color = "黄色";
    String food = "狗粮";

}

class Cat extends Animal{

    String name = "小菊";
    String color = "橘色";
    String food = "猫粮";

    public void move(){
        System.out.println("我是"+name+"我跑得很慢");
    }

}
