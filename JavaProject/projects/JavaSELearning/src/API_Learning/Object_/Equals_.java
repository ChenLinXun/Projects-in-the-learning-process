package API_Learning.Object_;
/*
 * == 运算符和equals()方法的区别：
 * ==运算符：1.既可以判断基本类型也可以判断引用类型2.如果判断的是基本类型，则判断值是否相等
 *          3.如果判断的是引用类型，则判断地址是否相等，也就是看是不是地址相同的同一个对象
 * equals()：1.是Object类的方法，只能用于判断引用类型
 *           2.默认判断的是地址是否相等，子类往往会重写这个方法，判断内容是否相等，
 *             比如：integer、String
 *
 * equals()方法注意事项：
 * 1. 如果判断两个对象是否“重复”的逻辑，不使用Object类的默认判断地址的逻辑
 *    而是根据设计者设计的逻辑进行判断，例如：比较对象的某些字段相同表示重复
 *    那么应该重写equals()方法
 * 2. 如果重写了equals()方法，那么通常应该重写hashCode的方法，
 *    这是在Object类equals()方法注释里说明的：
 *    每当重写此方法时，通常都需要重写hashCode方法，
 *    以维护hashCode方法的一般约定，即相等的对象必须具有相等的哈希码
 * 3. 对于第2点的解释：
 *    3.1 如果重写了equals()方法的对象，不是具有哈希结构的集合的元素，那么一般可以不重写hashCode()方法
 *        也就是说，这个不是硬性要求，不是编译上的问题，不按这样做也不会编译不通过
 *    3.2 如果重写了equals()方法的对象，是具有哈希结构的集合的元素，那么就一定要重写hashCode()方法，
 *        否则可能出现严重的逻辑错误（也不是编译上的错误），这个严重的逻辑错误是：
 *        很可能会向哈希结构的集合中添加了逻辑上“重复”的元素，而哈希结构的集合是不允许元素重复的
 */
public class Equals_ {

    public static void main(String[] args) {

        /*注意：String直接赋值和用new创建对象有很大区别，具体在String_包中查看*/
        //创建了两个String对象
        String s1 = new String("ChenLinXun");
        String s2 = new String("ChenLinXun");

        //使用==运算符判断两个对象是不是同一个（地址是否相同）
        System.out.println(s1 == s2);//new了两次，当然是false
        //使用String类重写Object类的equals方法，判断内容是否相同
        System.out.println(s1.equals(s2));//内容相同，true
        System.out.println("===============");


        //创建了两个integer对象
        Integer integer1 = 1000;
        Integer integer2 = 1000;

        //使用==运算符判断两个对象是不是同一个（地址是否相同）
        System.out.println(integer1 == integer2);//new了两次，当然是false
        //使用String类重写Object类的equals方法，判断内容是否相同
        System.out.println(integer1.equals(integer2));//内容相同，true
        System.out.println("===============");


        //自己也重写一个equals方法
        Worker chen = new Worker("陈林迅",10000);
        Worker worker = new Worker("陈林迅",10000);
        System.out.println(chen.equals(worker));

    }

}

class Worker{

    private String name;
    private double salary;//月工资

    public Worker(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if(obj instanceof Worker){
            Worker tempWorker = (Worker)obj;
            //注意：String类型属性的比较要用equals方法比较内容，double类型直接使用==运算符
            return tempWorker.getName().equals(this.getName()) && tempWorker.getSalary() == this.getSalary();
        }
        return false;
    }
}

