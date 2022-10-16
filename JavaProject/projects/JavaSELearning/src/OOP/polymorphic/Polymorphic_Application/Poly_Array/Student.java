package OOP.polymorphic.Polymorphic_Application.Poly_Array;

public class Student extends Person {

    private double score;

    public Student(String name, double score) {
        super(name);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public void say() {
        System.out.println("我是学生"+getName()+"Java期末考试成绩是："+getScore());
    }
}
