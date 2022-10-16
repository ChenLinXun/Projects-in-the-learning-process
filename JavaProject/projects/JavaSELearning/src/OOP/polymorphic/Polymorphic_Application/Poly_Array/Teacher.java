package OOP.polymorphic.Polymorphic_Application.Poly_Array;

public class Teacher extends Person {

    private double salary;

    public Teacher(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void say() {
        System.out.println("我是老师"+getName()+"我的工资是："+getSalary());
    }
}
