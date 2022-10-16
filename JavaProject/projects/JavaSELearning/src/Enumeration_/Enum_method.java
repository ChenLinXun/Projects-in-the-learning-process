package Enumeration_;

/*
 * Enum类成员方法的使用：
 * 由于用enum创建枚举类会继承Enum类，因此可以使用Enum类的一些成员方法
 * 看以下代码示例
 */
public class Enum_method{

    public static void main(String[] args) {

        Enum_Season2 spring = Enum_Season2.SPRING;

        //toString()：重写了toString，返回枚举类对象常量的常量名
        System.out.println(spring.toString());

        //name()：返回枚举类对象常量的常量名
        System.out.println(spring.name());

        //ordinal()：返回枚举对象常量的次序（编号，从零开始编）
        System.out.println(spring.ordinal());

        //values()：返回枚举类数组 Enum_Season2[]
        //含有定义的所有枚举对象（这个方法在反编译中可以看到）
        Enum_Season2[] values = Enum_Season2.values();
        for (Enum_Season2 enum_season2 : values) {//增强for循环
            System.out.println(enum_season2);
        }

        //valueOf(String name)：根据字符串name找到与其匹配的枚举对象常量并返回
        Enum_Season2 enum_season2 = Enum_Season2.valueOf("SPRING");
        System.out.println(enum_season2);
        System.out.println(enum_season2 == spring);

        //compareTo(枚举类对象常量)：比较两个枚举对象常量的编号
        //返回值是：括号外对象常量的编号减括号内的对象常量的编号
        System.out.println(spring.compareTo(Enum_Season2.WINTER));

    }
}

enum Enum_Season2{

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

    Enum_Season2(String season, String desc) {
        this.season = season;
        this.desc = desc;
    }

}
