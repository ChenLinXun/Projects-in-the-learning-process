package API_Learning.Object_;
/*
 * 1.默认返回全类名（包名加类名）+@+哈希值的十六进制
 * 2.子类往往会重写toString方法，用于返回对象的属性信息
 * 3.输出一个对象时，toString默认被调用
 */
public class ToString_ {

    public static void main(String[] args) {

        Object obj = new Object();
        //调用Object类默认的toString方法
        System.out.println(obj.toString());
        //输出一个对象时，toString默认被调用
        System.out.println(obj);

        Monster monster = new Monster("小妖怪", "巡山的", 1000);
        //调用重写后的toString方法
        System.out.println(monster.toString());
        //输出一个对象时，toString默认被调用
        System.out.println(monster);
    }

}

class Monster{

    private String name;
    private String job;
    private double sal;

    public Monster() {
    }

    public Monster(String name, String job, double sal) {
        this.name = name;
        this.job = job;
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", sal=" + sal +
                '}';
    }
}
