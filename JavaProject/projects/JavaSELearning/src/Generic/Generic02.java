package Generic;
import java.util.ArrayList;
import java.util.List;
/*
 * 泛型的继承和通配符:
 * 1.  泛型不具备继承性，例如这样是错误的：
 *     List<Object> list = new ArrayList<String>();
 * 2.  <?>：支持任意泛型类型
 * 3.  <? extends A>：支持A类以及A类的子类，规定了泛型的上限
 * 4.  <? super A>：支持A类以及A类的父类，不限于直接父类，规定了泛型的下限
 */
public class Generic02 {

    public static void main(String[] args) {

        //定义内容为三种类型的集合
        ArrayList<AA> list1 = new ArrayList<>();
        ArrayList<BB> list2 = new ArrayList<>();
        ArrayList<CC> list3 = new ArrayList<>();

        //类型不受限制，正确使用
        printList1(list1);
        //这里只能传入BB、CC泛型类型的List
        printList2(list2);
        printList2(list3);
        //这里只能传入BB、AA泛型类型的List
        printList3(list2);
        printList3(list1);
    }

    //传入的List的泛型类型可以是任意类型
    public static void printList1(List<?> list){
        for (Object o : list) {
            System.out.println(o);
        }
    }

    //传入的List的泛型类型必须是BB或BB的子类型
    public static void printList2(List<? extends BB> list){
        for (Object o : list) {
            System.out.println(o);
        }
    }

    //传入的List的泛型类型必须是BB或BB的父类型
    public static void printList3(List<? super BB> list){
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
class AA{}
class BB extends AA{}
class CC extends BB{}