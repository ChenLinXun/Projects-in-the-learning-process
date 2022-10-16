package OOP.polymorphic.Polymorphic_Application.Poly_Parameter;

public class Worker extends Employee {

    public Worker() {
    }

    public Worker(String name, double salary) {
        super(name, salary);
    }

    public void work(){
        System.out.println("普通员工"+getName()+"正在工作");
    }

    @Override
    public double getAnnual() {//普通员工没有其他收入
        return super.getAnnual();
    }

}
