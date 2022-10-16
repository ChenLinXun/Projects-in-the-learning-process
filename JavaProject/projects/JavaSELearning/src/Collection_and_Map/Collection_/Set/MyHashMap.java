package Collection_and_Map.Collection_.Set;
/*
 * 简单模拟一个数组+链表的结构：哈希表，也称散列表
 */
public class MyHashMap {

    public static void main(String[] args) {

        //创建一个table
        Node[] table = new Node[3];

        //在table中加入元素
        table[0] = new Node("Rick",null);
        table[1] = new Node("Daryl",null);
        table[2] = new Node("Glen",null);

        //在table元素上挂载元素，形成链表
        table[0].next = new Node("Lori",new Node("Carl",null));
        table[1].next = new Node("Carol",null);
        table[2].next = new Node("Maggie",null);
        //table+链表形成一个简单的Map

        //遍历Map元素
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i]);
        }

    }

}

class Node{

    String item;
    Node next;

    public Node(String item, Node next) {
        this.item = item;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "item='" + item + '\''+
                '}' +
                "--->" + next ;
    }
}