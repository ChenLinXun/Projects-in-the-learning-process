package Enumeration_;
/*
 * 枚举：
 * 枚是一个个的，举是列举。顾名思义枚举类就是列出一个个对象的类；英文是：enumeration，通常简写为enum
 * 应用场景：
 * 当我们设计一个类，这个类只有固定的几个对象，不希望被修改，那么可以把这个类定义为枚举类
 * 例如：
 * 设计一个季节类，一年四个季节，那么设计的初衷是这个类的对象只应该定义春夏秋冬四个对象，
 * 不应该出现别的对象，更不能对春夏秋冬其中一个对象进行修改
 * 定义枚举类有两种方法：
 * 1. 自定义枚举类 2. 利用enum关键字创建枚举类
 */

/*
 * 自定义枚举类
 * 自定义枚举类的方法：
 * 1. 构造器私有化，防止直接new
 * 2. 不设置set方法，防止对象属性被修改，可以设置get，对象属性只读
 * 3. 在枚举类中创建枚举类对象，用static、final修饰，同时使用实现底层优化 
 *    获取时直接用枚举类名获取，并且不需要加载枚举类
 * 4. 枚举类对象名字全字母用大写，常量的命名规范
 */
public class Custom_enum {

    public static void main(String[] args) {
        System.out.println(Season.SPRING.getSeason()+","+Season.SPRING.getDesc());
        System.out.println(Season.SUMMER.getSeason()+","+Season.SUMMER.getDesc());
        System.out.println(Season.AUTUMN.getSeason()+","+Season.AUTUMN.getDesc());
        System.out.println(Season.WINTER.getSeason()+","+Season.WINTER.getDesc());
    }

}

class Season{

    private String season;
    private String desc;//描述

    public static final Season SPRING = new Season("春天","温暖");
    public static final Season SUMMER = new Season("夏天","炎热");
    public static final Season AUTUMN = new Season("秋天","凉爽");
    public static final Season WINTER = new Season("冬天","寒冷");

    public String getSeason() {
        return season;
    }

    public String getDesc() {
        return desc;
    }

    private Season(String season, String desc) {
        this.season = season;
        this.desc = desc;
    }

}