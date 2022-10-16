package Collection_and_Map.Collection_.List;
import java.util.ArrayList;
import java.util.LinkedList;
/*
 * List集合的选择：
 * 1.  如果我们改查的操作多，选择ArrayList
 * 2.  如果我们增删的操作多，选择LinkedList
 * 3.  一般来说，在程序中，80%-90%都是查询，因此大部分情况下会选择ArrayList
 * 4.  在一个项目中，根据业务灵活选择，也可能这样，一个模块使用的是ArrayList， 
 *     另外一个模块是LinkedList，也就是说,要根据业务来进行选择
 */
public class ListChoose {

    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        long start;
        long end;

        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();

        //测试增（删）效率
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrayList.add("测试增加效率");
        }
        end = System.currentTimeMillis();
        System.out.println("ArrayList增加元素执行时间："+(end - start));


        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkedList.add("测试增加效率");
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList增加元素执行时间："+(end - start));

        System.out.println("-------------------------------------------");

        //测试查（改）效率
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrayList.get(i);
        }
        end = System.currentTimeMillis();
        System.out.println("ArrayList查询元素执行时间："+(end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkedList.get(i);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList查询元素执行时间："+(end - start));

    }

}
