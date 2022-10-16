package OOP.innerClass_.memberInnerClass_;
/*
 * 静态内部类：定义在外部类的成员位置上，而且有static修饰
 * 使用细节和注意事项：
 * 1. 可以直接访问外部类的所有静态成员包括私有的，非静态的不行
 * 2. 地位是一个成员属性，可以用访问修饰符修饰
 * 3. 作用域和外部类其他成员一样
 * 4. 外部类方法访问成员内部类静态属性和静态方法：可以直接通过类名访问 
 *    访问普通属性和方法：先创建对象再访问
 * 5. 外部其他类访问静态内部类（要遵守访问权限）：有两种方法，看以下示例
 * 6. 若内部类成员和外部类成员重名，内部类访问时，访问采取就近原则 
 *    若仍想调用外部类成员时，可以这样使用：外部类名.外部成员
 */

//外部其他类
public class Static_MemberInner {

    public static void main(String[] args) {
        //简单使用：
        Outer2 outer = new Outer2();
        outer.sayHello();

        //外部其他类访问外部类中的静态内部类中的成员：
        //方法一：
        //因为MemberInner是静态的不用再new一次，直接点就行
        Outer2.s_MemberInner s_memberInner = new Outer2.s_MemberInner();
        Outer2.s_MemberInner.say();
        s_memberInner.say2();

        //方法二：
        //在外部类Outer中写一个可以返回一个memberInner实例的方法
        Outer2.s_MemberInner s_memberInner1 = outer.getMemberInner();
        s_memberInner1.say2();
    }

}

//外部类
class Outer2{

    private static int age = 21;
    private static String name = "陈林迅";

    //定义在成员位置的静态内部类
    public static class s_MemberInner{

        private int age = 22;

        public static void say(){
            //可以使用：外部类名.外部成员 访问出现重名的外部类属性
            System.out.println("我叫"+name+"，今年"+Outer2.age);
        }

        public void say2(){
            System.out.println("虚岁"+age);
        }

    }

    //可以在方法中使用
    public void sayHello(){
        s_MemberInner.say();
    }

    public s_MemberInner getMemberInner(){
        return new s_MemberInner();
    }

}