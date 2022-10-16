package Collection_and_Map.Utils;
import java.util.*;
/*
 * Collections工具类介绍：
 * 1.  Collections是一个操作 Set、List 和 Map 等集合的工具类
 * 2.  Collections中提供了一系列静态的方法对集合元素进行排序、查询和修改等操作
 */
public class Collections_ {

    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        List list = new ArrayList();
        list.add("Rick");
        list.add("Drayl");
        list.add("Glen");
        list.add("Maggie");
        System.out.println(list);

        //排序操作：
        //翻转元素顺序
        Collections.reverse(list);
        System.out.println(list);
        //自然排序元素
        Collections.sort(list);
        System.out.println(list);
        //随机排序元素
        Collections.shuffle(list);
        System.out.println(list);

        //查找、替换：
        //根据元素的自然顺序，返回给定集合中的最大/最小元素
        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));
        //返回指定集合中指定元素的出现次数
        System.out.println(Collections.frequency(list,"Rick"));
        //拷贝集合元素到另一个集合中，被拷贝的集合元素要大于等于源集合，最好等于
        ArrayList list1 = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            list1.add("");
        }
        Collections.copy(list1,list);
        System.out.println(list1);
        //使用新值替换 List 对象的所有旧值
        Collections.replaceAll(list,"Rick","Carl");
        System.out.println(list);

    }

}
