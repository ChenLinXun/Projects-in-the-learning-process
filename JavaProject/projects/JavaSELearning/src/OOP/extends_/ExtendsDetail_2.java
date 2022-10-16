package OOP.extends_;

/*
 * 类不存在有参构造，无参构造没有显示定义（没写出来），则会默认存在一个无参构造，
 * 一旦类存在有参构造，并且无参构造没有显示定义（没写出来），则类就没有无参构造
 */


/*
 * 创建子类对象时，无论使用子类的哪一个构造器，都默认调用父类的无参构造器来初始化，
 * 若父类没有无参构造器，则必须在子类构造器中用super()指定一个父类的构造器完成父类的初始化工作，
 * 否则编译将不通过
 * （因此，创建一个类的有参构造时，最好把无参构造写上，
 * 避免其子类对象创建时无法找到父类无参构造完成初始化而造成错误）
 */

public class ExtendsDetail_2 {

    public static void main(String[] args) {
        new son1(1);
    }

}

class Father1 {

    public Father1(int i) {
        System.out.println("已完成父类father的初始化，传入参数为: "+i);
    }

}

class son1 extends Father1 {

    public son1(int i) {
        super(i);//父类构造必须写在子类构造里的第一行
        System.out.println("成功创建子类son1对象");
    }

}