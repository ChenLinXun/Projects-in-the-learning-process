package OOP.abstract_;

/*
 * 抽象类和抽象方法
 * 引出:父类方法的不确定性：当父类的某些方法需要声明但是还不知道怎么实现时，
 *     可以将此方法声明为抽象方法则这个类就变成了抽象类，必须用abstract修饰
 */

/*
 * 使用方法：
 * 1. 用abstract修饰的类就是一个抽象类
 * 2. 用abstract修饰的方法就是抽象方法，抽象方法没有实现，也就是没有方法体（没有大括号）
 * 3. 抽象类的价值作用更多是在于设计，是设计者设计好后，让子类继承并实现
 * 4. 抽象类在框架和设计模式中用得很多
 */

/*
 *使用细节：
 * 1. 抽象类不能被实例化
 * 2. 抽象类不一定包含抽象方法，可以没有抽象方法
 * 3. 一旦类包含了抽象方法，那么这个类必须声明为抽象类
 * 4. abstract只能修饰类和方法
 * 5. 抽象类本质当然还是类，普通类可以有的东西抽象类都可以有
 * 6. 抽象方法不能实现方法也就是不能有方法体
 * 7. 如果一个类继承了抽象类，则必须重写实现父类的所有抽象方法（有方法体，并且没有abstract修饰，方法体里可以不写东西）   否则也必须声明为抽象类
 * 8. 抽象方法不可以用private、static、final来修饰，因为这些都是和重写相违背的
 */

public class abstract_class_method {

    public static void main(String[] args) {

        Worker chen = new Worker("陈林迅", 1908, 10000);
        Manager zh = new Manager("张三", 1977, 25000, 10000);
        chen.work();
        zh.work();

    }

}

abstract class Employee{

    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public abstract void work();

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }
}

class Worker extends Employee{

    public Worker(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    public void work() {
        System.out.println("普通员工"+getName()+"工号"+getId()+"正在工作，"+"薪水："+getSalary());
    }
}

class Manager extends Employee{

    private double bonus;

    public double getBonus() {
        return bonus;
    }

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("经理"+getName()+"工号"+getId()+"正在工作，"+"薪水："+getSalary()+",奖金："+getBonus());
    }

}