package Enumeration_;
/*
 * 使用enum关键字实现方法:
 * 1. 用enum关键字替代class
 * 2. 常量对象定义语法：常量名(参数列表)，常量名用大写，规范
 * 3. 将定义对象常量写在最前面，多个对象常量用逗号分隔
 * 4. 设置属性get方法，不设置set方法，只读
 * 5. 其他类获取枚举类对象时，直接用枚举类名访问
 *
 * 使用细节和注意事项:
 * 1. 使用enum创建枚举类时，会隐式继承Enum类， 
 *    并且这个枚举类默认是final的，可以在命令行中 
 *    用javap命令反编译class文件来证实
 * 2. 用语法：常量名(参数列表) 创建常量对象时， 
 *    必须知道用的哪个构造器创建，如果是无参构造器可以省略括号
 * 3. 常量对象的定义必须写在枚举类中的最前面
 * 4. 常量对象默认是public static final的，其他类获取枚举类对象时，直接用枚举类名访问
 * 5. 由于用enum创建枚举类会隐式继承Enum类，所以不能再继承其他的类，但可以实现接口
 */
public class Enum_{

    public static void main(String[] args) {
        System.out.println(Enum_Season.SPRING.getSeason()+","+Enum_Season.SPRING.getDesc());
        System.out.println(Enum_Season.SUMMER.getSeason()+","+Enum_Season.SUMMER.getDesc());
        System.out.println(Enum_Season.AUTUMN.getSeason()+","+Enum_Season.AUTUMN.getDesc());
        System.out.println(Enum_Season.WINTER.getSeason()+","+Enum_Season.WINTER.getDesc());
    }

}

enum Enum_Season{

    SPRING("春天","温暖"),SUMMER("夏天","炎热"),
    AUTUMN("秋天","凉爽"),WINTER("冬天","寒冷");

    private String season;
    private String desc;//描述

    public String getSeason() {
        return season;
    }

    public String getDesc() {
        return desc;
    }

    Enum_Season(String season, String desc) {
        this.season = season;
        this.desc = desc;
    }

}