package ZZZZZZZZZ;

public class ArrayTest {
    public static void main(String[] args) {
        int[] a = {0, 1, 2};
        System.out.println("a[0]：" + a[0]);
        change(a);
        System.out.println("a[0]：" + a[0]);

        System.out.println(a.hashCode()); //指向的是同一个对象
    }
    public static void change(int[] arr){
        arr[0] = 6;
        System.out.println(arr.hashCode()); //指向的是同一个对象
    }
}
