package OOP.innerClass_.memberInnerClass_;
/*
 * 成员内部类：定义在外部类的成员位置上，并没有static修饰
 * 使用细节和注意事项：
 * 1. 可以直接访问外部类的所有成员包括私有的
 * 2. 地位是一个成员属性，可以用访问修饰符修饰
 * 3. 作用域和外部类其他成员一样
 * 4. 外部类方法访问成员内部类属性和方法：先创建对象再访问
 * 5. 外部其他类访问成员内部类：有两种方法，看以下示例
 * 6. 若内部类成员和外部类成员重名，内部类访问时，访问采取就近原则 
 *    若仍想调用外部类成员时，可以这样使用：外部类名.this.外部成员
 */

//外部其他类
public class MemberInner {

    public static void main(String[] args) {
        //简单使用：
        Outer outer = new Outer();
        outer.sayHello();

        //外部其他类访问外部类中的成员内部类中的成员：

        //方法一：
        //把outer.new memberInner()看作是outer的一个成员属性Outer.memberInner，只不过这个属性是一个类
        Outer.MemberInner memberInner = outer.new MemberInner();
        memberInner.say();
        //方法一可以把outer的创建合在一起写：
        Outer.MemberInner memberInner1 = new Outer().new MemberInner();
        memberInner1.say();

        //方法二：
        //在外部类Outer中写一个可以返回一个memberInner实例的方法
        Outer.MemberInner memberInner2 = outer.getMemberInner();
        memberInner2.say();
        memberInner2.say2();

    }

}

//外部类
class Outer{

    private int age = 21;
    private String name = "陈林迅";

    //定义在成员位置的成员内部类
    public class MemberInner{

        private int age = 22;

        public void say(){
            //可以使用：外部类名.this.外部成员 访问出现重名的外部类属性
            System.out.println("我叫"+name+"，今年"+Outer.this.age);
        }

        public void say2(){
            System.out.println("虚岁"+age);
        }

    }

    //可以在方法中使用
    public void sayHello(){
        new MemberInner().say();
    }

    public MemberInner getMemberInner(){
        return new MemberInner();
    }

}
