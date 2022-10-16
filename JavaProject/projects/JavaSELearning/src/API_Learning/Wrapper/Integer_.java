package API_Learning.Wrapper;

public class Integer_ {

    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        /*
            手动装箱调用的方法：
            Integer构造器源码：
            public Integer(int value) {
                this.value = value;
            }

            自动装箱调用的方法：
            valueOf方法源码：
            public static Integer valueOf(int i) {
                if (i >= Integer.IntegerCache.low && i <= Integer.IntegerCache.high)
                    return Integer.IntegerCache.cache[i + (-Integer.IntegerCache.low)];
                return new Integer(i);
            }
            IntegerCache.cache 说明：cache是一个Integer数组，从-128到127
            所以调用此方法创建Integer对象，传入的值在-128到127之间，直接返回这个创建好的cache对象
         */

        Integer n = 120;//自动装箱，这样赋值实际上调用的是valueOf方法
        int m = 120;
        System.out.println(n == m);//包装类和基本类型比较，都是比较值

        Integer x = new Integer(120);//手动装箱，调用构造器，此构造器java9后已过时
        Integer y = 120;
        System.out.println(x == y);//x是new出来的新的对象，y是IntegerCache中的cache[248]

        System.out.println(n == y);//n和y都是IntegerCache中的cache[248]

        Integer u = 128;
        Integer v = 128;
        System.out.println(u == v);//u和v都超过了IntegerCache.cache的范围，于是都是新的对象

    }

}

