package OOP.innerClass_.localInnerClass_;
/*
 * 局部内部类（有类名）：定义在外部类的局部位置（方法、代码块）上
 * 使用细节：
 * 1. 可以直接访问外部类的所有成员，包括私有的
 * 2. 本质仍然是一个类，地位相当于一个局部变量，不可以用访问修饰符修饰，可以用final修饰，
 *    因为局部变量可以被final修饰
 * 3. 作用域仅仅在所处的方法或代码块中，在这个方法或代码块以外的地方不可以访问
 * 4. 所在的方法或代码块中可以创建这个局部内部类的对象，进行调用方法或访问成员
 * 5. 若内部类成员和外部类成员重名，访问采取就近原则
 *    若仍想调用外部类成员时，可以这样使用：外部类名.this.外部成员 
 *   （外部类名.this 实际上就是调用了包含了这个内部类的方法的外部类对象）
 */

//外部其他类
public class LocalInner{
    public static void main(String[] args) {
        new Outer().inner();
    }
}

//外部类
class Outer {

    private String name = "外部类";

    public void t(){
        System.out.println("hehe");
    }

    public void inner(){

        //内部类
        class innerClass{

            private String name = "局部内部类";

            public void t(){
                System.out.println("haha");
            }

            //内部类可以直接调用外部类的所有成员，包括私有的：
            public void say(){
                //若内部类成员和外部类成员重名，采取就近原则
                System.out.println("这是一个"+name);
                t();

                //若想访问外部类的重名成员，可以：外部类名.this.成员
                //(LocalInner.this 实际上就是调用了inner（）方法的LocalInner对象)
                System.out.println("外面的是一个"+Outer.this.name);
                Outer.this.t();
            }

        }
        //在局部内部类所在的方法中可以创建局部内部类对象
        innerClass innerClass = new innerClass();
        innerClass.say();
    }

}
