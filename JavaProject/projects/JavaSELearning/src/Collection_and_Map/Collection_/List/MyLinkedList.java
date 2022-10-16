package Collection_and_Map.Collection_.List;
/*
 * 模拟一个双向链表
 */
public class MyLinkedList {

    public static void main(String[] args) {

        //创建三个节点
        Node rick = new Node("Rick");
        Node daryl = new Node("Daryl");
        Node glen = new Node("Glen");

        //创建头尾指针
        Node first;
        Node last;

        //连接节点，形成双向链表
        rick.next = daryl;
        daryl.next = glen;
        glen.prev = daryl;
        daryl.prev = rick;

        //设置头尾指针指向
        first = rick;
        last = glen;

        //遍历：
        //1.从头遍历
        System.out.println("----------------------------");
        System.out.println("从头遍历：");
        while (first != null){
            //输出当前节点信息
            System.out.println(first);
            //将头指针向后移
            first = first.next;
        }
        first = rick; //头指针归位
        System.out.println("----------------------------");

        //2.从尾遍历
        System.out.println("从尾遍历：");
        while (last != null){
            //输出当前节点信息
            System.out.println(last);
            //将尾指针向前移
            last = last.prev;
        }
        last = glen; //尾指针归位
        System.out.println("----------------------------");


        //增：
        //在Rick后添加一个节点
        Node chen = new Node("Chen");
        //从头遍历
        while (first != null){
            //当头指针指到Rick位置时
            if(first.item.equals("Rick")){
                //将chen对后一个元素的指向，改为指向Rick的后一个元素（Daryl）
                chen.next = first.next;
                //将chen对前一个元素的指向，改为Rick
                chen.prev = first;
                //将Rick原本的后一个元素（Daryl）的前指向，改为指向Chen
                first.next.prev = chen;
                //将Rick原本对后一个元素（Daryl）的指向，改为指向Chen
                first.next = chen;

                break;//结束循环
            }
            //将头指针向后移
            first = first.next;
        }
        first = rick; //头指针归位
        //添加完成，再遍历一遍
        //从头遍历
        System.out.println("增加了新节点后，从头遍历：");
        while (first != null){
            //输出当前节点信息
            System.out.println(first);
            //将头指针向后移
            first = first.next;
        }
        first = rick; //头指针归位
        System.out.println("----------------------------");


        //删：
        //删除Rick后面的一个节点
        while (first != null){
            //当头指针指到Rick位置时
            if(first.item.equals("Rick")){
                //缓存要删除的节点
                Node del = first.next;
                //修改要删除节点的前节点的后指向
                first.next = del.next;
                //修改要删除节点的后节点的前指向
                del.next.prev = first;
                //让要删除节点的前后指向都指向空对象，GC会回收它
                del.next = null;
                del.prev = null;

                break; //结束循环
            }
            //将头指针向后移
            first = first.next;
        }
        first = rick; //头指针归位
        //删除完成，再遍历一遍
        //从头遍历
        System.out.println("删除了新节点后，从头遍历：");
        while (first != null){
            //输出当前节点信息
            System.out.println(first);
            //将头指针向后移
            first = first.next;
        }
        first = rick; //头指针归位
        System.out.println("----------------------------");
    }

}

class Node{

    String item;
    Node prev;   //前指针
    Node next;  //后指针

    public Node(String name) {
        this.item = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + item + '\'' +
                '}';
    }
}
