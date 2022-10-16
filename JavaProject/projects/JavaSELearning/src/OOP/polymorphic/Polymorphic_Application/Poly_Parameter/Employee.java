package OOP.polymorphic.Polymorphic_Application.Poly_Parameter;

public class Employee {

    private String name;
    private double salary;//月工资

    public Employee(){

    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    //获取年薪
    public double getAnnual(){
        return 12*salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


}
