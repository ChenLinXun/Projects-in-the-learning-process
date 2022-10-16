package API_Learning.StringBuffer_StringBuilder;
/*
 * String、StringBuffer、StringBuilder的区别：
 *
 * 1.String：不可变字符序列，效率低，但是复用率高。
 *
 * 2.StringBuffer：可变字符序列、效率较高(增删)、线程安全
 *
 * 3.StringBuilder：可变字符序列、效率最高、线程不安全
 *
 * 4.StringBuilder和StringBuffer非常类似，均代表可变的字符序列， 
 *   方法和方法的使用一样，但StringBuilder方法不是线程安全的
 */
public class Contrast {

    public static void main(String[] args) {

        //创建三个字符串对象
        String string = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");

        //定义运行时间
        long start = 0L;
        long end = 0L;

        //检测StringBuffer
        start = System.currentTimeMillis();
        for (int i = 0; i < 60000; i++) {
            buffer.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuffer执行时间："+(end - start));

        //检测StringBuilder
        start = System.currentTimeMillis();
        for (int i = 0; i < 60000; i++) {
            builder.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuilder执行时间："+(end - start));

        //检测String
        start = System.currentTimeMillis();
        for (int i = 0; i < 60000; i++) {
            string += i;
        }
        end = System.currentTimeMillis();
        System.out.println("String执行时间："+(end - start));

    }

}
