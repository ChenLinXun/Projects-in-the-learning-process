package OOP.polymorphic.Polymorphic_Application.Poly_Parameter;

public class Manager extends Employee{

    private double bonus;//奖金

    public Manager() {
    }

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void manage(){
        System.out.println("经理"+getName()+"正在管理工作");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual()+ bonus;
    }
}
