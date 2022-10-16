package Generic;
/*
 * 泛型的介绍：
 * 1. 泛型又称参数化类型，是Jdk5.0出现的新特性，解决数据类型的安全性问题
 * 2. 在类声明或实例化时只要指定好需要的具体的类型即可
 * 3. Java泛型可以保证如果程序在编译时没有发出警告，运行时就不会产生ClassCastException异常。
 *    同时，代码更加简洁、健壮
 * 4. 泛型的作用是：
 *    可以在类声明时通过一个标识表示类中某个属性的类型，或者是某个方法的返回值的类型，或者是参数类型。
 */
public class Generic01 {

    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //使用了泛型
        Couple<String, Integer> couple = new Couple<>("Rick",35);
        String key = couple.getKey();
        Integer value = couple.getValue();
        System.out.println(key+"-"+value);

        //默认使用泛型，泛型类型为Object
        Couple couple1 = new Couple("Daryl", 36);
        Object key1 = couple1.getKey();
        Object value1 = couple1.getValue();
        System.out.println(key1+"-"+value1);
    }

}
//自定义泛型接口
interface A<K,V> {
    //自定义泛型方法
    K getKey();
    V getValue();
}
//自定义泛型类
class Couple<K,V> implements A{

    K key;
    V value;

    public Couple(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
}







