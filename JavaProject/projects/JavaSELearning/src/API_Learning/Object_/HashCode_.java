package API_Learning.Object_;
/*
 * 1.两个引用，如果指向的是地址相同的同一个对象，则哈希值肯定是一样的
 * 2.两个引用，如果指向的是地址不同的两个对象，则哈希值一般是不一样的，一样的概率很小
 * 3.哈希值是根据对象的内部地址转换成一个整数实现的，但是不能等价于地址号，java语言不需要这种实现技巧
 * 4.如果对象所属的类重写了hashCode()方法，那么对象的hashCode值不再是默认的根据地址计算得出，
 *   而是根据设计者的逻辑计算出hashCode值，例如：
 *   String类中重写了equals()和hashCode()方法： 
 *   比较两个String对象的底层字符数组value的每一个字符，
 *   如果相同，则equals()返回true，hashCode()返回相同的hashCode值
 * 5.在集合中，如果有需要也会重写hashCode方法，提高具有哈希结构的容器的效率
 * 6.所以综上所述判断两个对象是否“重复”，不能简单的用其hashCode值区分；
 *   若要判断两个对象是否为地址相同的对象，应该用“==”运算符比较
 */
public class HashCode_ {

    public static void main(String[] args) {

        //person1 和 person2是两个对象，hashCode不同
        Person person1 = new Person();
        Person person2 = new Person();
        //person1 和 person3是同一个对象，hashCode必定相同
        Person person3 = person1;
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
        System.out.println(person3.hashCode());
        System.out.println("----------------------------------");

        //s1 和 s2是堆中的两个不同的String对象，但是! 他们的hashCode是一样的
        //所以不能通过哈希值来判断两个对象是否是同一个，这不是绝对的
        String s1 = new String("Chen");
        String s2 = new String("Chen");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println("----------------------------------");

        //重写了Dog的hashCode方法，因此不同Dog对象的hashCode值也一样
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        System.out.println(dog1.hashCode());
        System.out.println(dog2.hashCode());
    }

}
class Person{}
class Dog{
    @Override
    public int hashCode() {
        return 100;
    }
}