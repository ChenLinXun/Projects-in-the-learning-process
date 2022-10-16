package OOP.polymorphic.Polymorphic_Application.Poly_Array;

/*多态数组的用例：
  遍历多态数组
*/

public class Test {

    public static void main(String[] args) {

        //创建多态数组
        Person[] persons = new Person[5];
        persons[0] = new Person("小明");
        persons[1] = new Student("小红",90);
        persons[2] = new Student("陈林迅",100);
        persons[3] = new Teacher("张老师",8000);
        persons[4] = new Teacher("李老师",10000);

        //遍历多态数组
        for (int i = 0; i < persons.length; i++) {
            persons[i].say();
        }

    }

}
