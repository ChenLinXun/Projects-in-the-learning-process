package OOP.polymorphic.Polymorphic_Application.Poly_Array;

public class Person {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public void say(){
        System.out.println("我是"+getName());
    }
}
