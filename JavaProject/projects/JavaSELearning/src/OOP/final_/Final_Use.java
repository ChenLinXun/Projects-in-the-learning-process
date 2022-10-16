package OOP.final_;

/*
 * 基本使用：
 * final中文意思:最后的，最终的.
 * final可以修饰类、属性、方法和局部变量.在某些情况下,程序员可能有以下需求,就会使用到final:
 * 1)当不希望类被继承时,可以用final修饰.
 * 2)当不希望父类的某个方法被子类覆盖/重写(override)时,可以用final关键字修饰。
 * 3)当不希望类的的某个属性的值被修改,可以用final修饰.
 * 4)当不希望某个局部变量被修改,可以使用final修饰
 *
 */

/*
 * 使用细节：
 * 1) final修饰的属性又叫常量,一般用xx_xx_xx来命名
 * 2) final修饰的属性在定义时,必须赋初值,并且以后不能再修改，赋值可以在如下位置之一【选择一个位置赋初值即可】:   
 *    1.定义时   
 *    2.在构造器中   
 *    3.在代码块中
 * 3)如果final修饰的属性是静态的，则初始化的位置只能是: 
 *   1.定义时 
 *   2.在静态代码块 （不能在构造器中赋值） 
 * 4) final类不能继承,但是可以实例化对象
 * 5)如果类不是final类，但是含有final方法，则该方法虽然不能重写，但是可以被继承
 * 6)如果一个类已经是final类了，它的方法就没必要再设置成final类型了，因为不会被继承就不会被重写
 * 7)final不能修饰构造器
 * 8)final和static往往搭配使用，当调用被这两个修饰符修饰的成员时类不会被加载，效率更高，底层编译器做了优化处理
 * 9)许多包装类（例如Integer、Double、Float、String）都是final类
 */

public class Final_Use {

    public static void main(String[] args) {
        //调用static final成员不会导致类的加载
        System.out.println(Person.F_Num);
        Person.tt();
    }

}

class Person{

    static final int F_Num=888;

    public Person() {
        System.out.println("类被加载了");
    }

    static final void tt(){
        System.out.println("调用了static final方法");
    }

}