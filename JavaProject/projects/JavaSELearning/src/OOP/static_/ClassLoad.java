package OOP.static_;
/*
 * 创建一个对象时,在一个类调用顺序是（重点，难点）：   
 * 1)调用静态代码块和静态属性初始化(注意:静态代码块和静态属性初始化调用的优先级一样，
 *   如果有多个静态代码块和多个静态变量初始化，则按他们定义的顺序调用)   
 * 2)调用普通代码块和普通属性的初始化(注意:普通代码块和普通属性初始化调用的优先级一样,
 *   如果有多个普通代码块和多个普通属性初始化，则按定义顺序调用) 
 * 3)调用构造方法。
 */

/*
 * 创建一个子类对象时，调用的顺序是（重点，难点）： 
 * 1)父类的静态代码块和静态属性(优先级一样,按定义顺序执行)   
 * 2)子类的静态代码块和静态属性(优先级一样，按定义顺序执行) 
 * 3)父类的普通代码块和普通属性初始化(优先级一样，按定义顺序执行) 
 * 4)父类的构造方法   
 * 5)子类的普通代码块和普通属性初始化(优先级一样，按定义顺序执行) 
 * 6)子类的构造方法 
 *  
 * 解释：类的构造器中都隐含了super（）和普通代码块，super（）在第一行；
 *      所以父类构造器和子类的普通代码块及普通属性初始化优先子类构造器执行
 */

/*
 * 注意事项： 
 * 1.普通的代码块，在创建对象实例时，会被隐式的调用。被创建一次，就会调用一次。     
 *   而静态代码块执行一次后就不再执行   
 * 2.如果只是使用类的静态成员时，普通代码块不会执行 
 * 3.静态代码块只能调用静态属性和静态方法，普通代码块可以调用任意成员
 */

public class ClassLoad {
    public static void main(String[] args) {

        A ab = new B();//父类的引用,结果和new B();是一样的，只是引用不同而已
        System.out.println("===============");
        ab = new B();
        System.out.println("===============");
        //两次new B类对象的区别：类信息加载顺序是一致的，但由于第一次new的时候已经加载了静态字段与代码块，
        //所以第二次就没有了这些步骤

        //如果只是使用类的静态成员时，普通代码块不会执行，但由于第一次new的时候已经加载了静态字段与代码块，
        //所以就没有了这些步骤
        A.tt();
    }
}

class A {
    private static int numA;
    private int numA2;

    static {
        System.out.println("A的静态字段 : " + numA);
        System.out.println("A的静态代码块");
    }

    {
        System.out.println("A的成员变量  : " + numA2);
        System.out.println("A的非静态代码块");
    }

    public static void tt(){
        System.out.println("hah");
    }

    public A() {
        System.out.println("A的构造器");
    }
}

class B extends A {
    private static int numB;
    private int numB2;

    static {
        System.out.println("B的静态字段 : " + numB);
        System.out.println("B的静态代码块");
    }

    {
        System.out.println("B的成员变量 : " + numB2);
        System.out.println("B的非静态代码块");
    }

    public B() {
        System.out.println("B的构造器");
    }
}

