package Collection_and_Map.Collection_.List;
import java.util.*;
/*
 * 迭代器介绍：
 * 1.  Collection接口继承了Iterable（可迭代的）接口，Iterable接口里只有一个需要实现的抽象方法：iterator() 
 *     iterator()方法返回的是一个Iterator接口实现类，Iterator接口中有两个用于迭代元素的方法。
 * 2.  这也就意味着所有的Collection实现子类都需要实现iterator()方法，而实现该方法需要写一个Iterator接口的 
 *     实现类，这样Collection实现子类调用iterator()方法时可获得一个Iterator接口实现类对象，也就是迭代器， 
 *     使用这个迭代器的方法即可遍历该集合的元素
 */
public class Iterator_ {

    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //下断点调试以下代码：

        ArrayList arr1 = new ArrayList(0);
        arr1.add("aa");
        arr1.add("bb");
        arr1.add("cc");

        Iterator iterator = arr1.iterator();
        //遍历：
        //快捷键：itit
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("-------------------------------");

        //增强for循环，本质上仍是迭代器（debug验证），快捷键：集合名.for
        for (Object o : arr1) {
            System.out.println(o);
        }
        System.out.println("-------------------------------");

        //remove：
        iterator = arr1.iterator();
        if (iterator.hasNext()) {

            iterator.next();//向下迭代一个元素,此时cursor为1，lastRet为0
            iterator.remove();//移除元素[lastRet]，所以移除的是第一个元素[0]

            //综上，并且根据老韩的解释：
            //在使用迭代器的时候，不必考虑底层的两个索引（头尾指针）的调动时，
            //可以想象成一个指针一开始指在-1的位置，然后每next一次，就下移一次
            //操作的是这个指针所指位置的元素

            //注意：两个remove不能连在一起用，第一次用后，lastRet会回到-1的位置
            //如果remove后又remove，会抛非法状态异常：IllegalStateException
            //iterator.remove();
        }
        System.out.println(arr1);
        System.out.println(arr1.size());
        System.out.println(arr1.get(1));

    }

}
