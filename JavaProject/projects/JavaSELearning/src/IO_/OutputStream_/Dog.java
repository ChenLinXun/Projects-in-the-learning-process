package IO_.OutputStream_;

import java.io.Serializable;

//序列化和反序列化的对象类，识别方式：全类名+序列化版本号
public class Dog implements Serializable {

    //快捷键：光标放在类上：alt+回车
    //生成唯一的序列化版本号
    private static final long serialVersionUID = -7435952414020750792L;

    private String name;
    private int age;

    //static或transient修饰的成员不会被序列化
    private transient String color;
    private static String nation = "中国";

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    public void say(){
        System.out.println("汪汪~~~");
    }
}
