package Collection_and_Map.Map_;
import java.util.*;
/*
 * HashMap扩容和树化机制:
 * 1.  HashMap表头扩容机制：     
 *      1.1  HashMap设置了一个表头扩容临界值threshold，当HashMap元素个数size超过它时       
 *           会对表头数组扩容2倍；     
 *      1.2  扩容临界值 = 当前表头数组容量 * 扩容因子
 *      1.3  扩容因子loadFactor，不用指定扩容因子构造器构造，默认是0.75
 *      1.4  使用无参构造，默认扩容因子0.75，第一次扩容时，默认表头数组容量为16，因此
 *           扩容临界值为12；HashMap元素超过12个时，扩容至32，临界值变成24，以此类推
 *      1.5  当某条链表的元素个数超过TREEIFY_THRESHOLD(默认是8)，table大小没到           
 *           MIN TREEIFY CAPACITY(默认64)，会对table扩容2倍
 *      1.6  HashMap扩容后可能会改变原来元素的索引位置，也就是可能移动链表或树
 * 2.  HashMap链表树化机制（红黑树）：
 *     在Java8中,如果一条链表的元素个数超过 TREEIFY_THRESHOLD(默认是8)，
 *     并且table的大小>=MIN TREEIFY CAPACITY(默认64)，就会进行树化(红黑树)
 *     否则采用扩容机制对表头扩容2倍
 *
 * 哈希碰撞：
 * 两个哈希表元素的键key通过哈希函数计算出的哈希表索引位置相同，
 * 也就是说他们应当放在哈希表中的位置冲突了（哈希函数可能导致这样的结果），
 * 那么说这两个元素发生了哈希碰撞
 *
 * 哈希集合的重要重写原则：
 * 如果重写了equals()方法的对象，是哈希结构集合的元素的键key，那么就一定要重写hashCode()方法。
 * 否则很可能出现严重的逻辑错误（不是编译上的错误），这个严重的逻辑错误是：
 * 很可能会向哈希结构的集合中添加了逻辑上“重复”的元素，而哈希结构的集合是不允许元素重复的
 * 在此原则上也应该尽可能使逻辑上不重复的对象返回不同hashCode值，减少哈希碰撞的发生，提高哈希容器效率
 */
public class HashMap_ {

    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //下断点调试以下程序：

        //一、模拟哈希碰撞的发生：
        System.out.println("模拟哈希碰撞的发生：");
        Map map = new HashMap();

        //new的所有Car的hashCode相同，加入HashMap发生时都发生哈希碰撞
        map.put(new Car("大众",5533),"进口");

        //那么调用equals()方法判断：
        //品牌相同但是id不同，则equals()为false，可以挂载
        map.put(new Car("大众",5500),"国产");

        //那么调用equals()方法判断：
        //品牌相同id也相同，则equals()为true，不可以挂载
        map.put(new Car("大众",5533),"进口");

        //那么调用equals()方法判断：
        //品牌和id都不同，则equals()为false，可以挂载
        map.put(new Car("五菱",5399),"国产");

        System.out.println(map);
        System.out.println("--------------------------------------------------------------");

        //二、演示正确使用HashMap添加元素
        System.out.println("演示正确使用HashMap添加元素：");

        Map map1 = new HashMap();

        //重要的重写原则：
        //向HashMap添加的元素的key对象，如果重写了equals()方法，则必须重写hashCode()方法
        //否则逻辑上重复的元素（也就是键key的equals()为ture的元素）调用默认的hashCode()方法
        //所得hashCode值不同，导致很有可能分配到不同的索引上（不发生哈希碰撞的情况下）
        //发生HashMap元素的重复
        //所以应当避免这种情况的发生，保证逻辑上重复的元素他们的hashCode值也相同
        //正确的例子：Student类

        map1.put(new Student("瑞克",1001),"留学生");
        //添加姓名和学号都相同的键key，一定添加失败，
        //因为二者相同他们的hashCode值相同，则索引位置必定相同，那么必定进行内容判断
        //内容判断时，equals()方法判断的也是姓名和学号，所以内容相同，发生重复，添加失败
        /*
          在这里可以看出重写原则的重要性：
          如果Student只重写了equals()方法，那么这两个姓名和学号都相同的重复元素会因为调用默认的
          hashCode()方法，根据地址获得一个不同的hashCode值，那么他们在加入HashMap中时，如果不发生
          哈希碰撞，得出不同的索引值，那么两者都可以加入到HashMap中，这是严重的错误！
         */
        map1.put(new Student("瑞克",1001),"本地学生");
        System.out.println(map1);

        //添加不重复的学生，测试发生哈希碰撞的概率
        //这里可以下断点慢慢试
        for (int i = 0; i < 30; i++) {
            map1.put(new Student("瑞克",i),"留学生");
        }//经测试，加入第11个元素的时候发生了碰撞

        //三、验证HashMap扩容和树化机制
        //直接看HashSet_程序，HashSet本质是HashMap，这里不再演示

    }

}

class Car{

    private String brand;
    private int id;

    public Car(String brand, int id) {
        this.brand = brand;
        this.id = id;
    }

    //为了模拟哈希碰撞的发生：
    //重写equals()方法和hashCode()方法，快捷键：
    //Alt+Insert：选择equals() and hashCode()

    //重写Car的equals()方法，当车的品牌和id号相同时返回true
    //模拟发生哈希碰撞时，比较equals()方法判断元素重复
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                Objects.equals(brand, car.brand);
    }
    //假设所有的Car对象的hashCode值都相同，加入HashMap时发生了哈希碰撞
    //注意！这里只是为了模拟碰撞发生，
    //不等价的对象应该尽可能地使他们的hashCode值不同，这有利于哈希表的效率，减少哈希碰撞的发生
    @Override
    public int hashCode() {
        return 100;
    }

    @Override
    public String toString() {
        return "Car[" + brand + id +']';
    }
}

class Student{

    private String name;
    private int id;//学号

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    //正确重写equals()方法和hashCode()方法
    //当学生的姓名和学号都相同时，返回相同的hashCode值，并且equals()判断为true
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "Student[" + name + id +']';
    }
}