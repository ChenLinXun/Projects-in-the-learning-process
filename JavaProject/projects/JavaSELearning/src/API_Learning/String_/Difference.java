package API_Learning.String_;

/* String类型直接赋值和用构造器：new String(String)创建对象的区别：
 *
 * 1.jdk1.6下，字符串池存放在jvm内存的方法区的永久代中；jdk1.7之后，字符串池存放在堆中，并且永久代被废除了
 *
 * 2.字符串池中存放的实际上还是字符串对象的引用，jdk1.7以前字符串池引用的对象放在方法区中，之后放到了堆中;
 *   现在普遍使用jdk1.7上的版本，所以为了区分堆中被字符串池引用的对象和直接在堆中创建被其他地方引用的对象,
 *   以下均称堆中被字符串池引用的对象为字符串池中的对象
 *
 * 3.当直接对一个String类型赋值时，会先在字符串池中寻找是否存在和这个值相同的String对象，
 *   如果没有，则在字符串池中创建这个对象，然后返回这个对象的引用；若寻找成功，则直接返回这个引用。
 *   结论是这样的赋值方法可能创建0或1个对象
 *
 * 4.当使用new String(String)创建String对象时，先在字符串常量池中创建一个对象，
 *   如果池中已经存在和其值相同的对象则不用创建，然后在堆中创建这个对象的副本，并返回。
 *   结论是用这样的赋值方法可能创建1或2个对象
 *
 * 5.String是不可变对象，只要创建就不能修改，所有的修改操作实际上都会创建新的String对象，
 *   若修改方式如：a = "b";则相当于在字符串常量池创建新的String对象并指向它，若已存在则直接返回引用
 *
 * 6.额外注意的是，在jdk1.7废除了永久代后，String的intern()方法也做了相应修改：
 *   jdk1.7以前：inter()方法是在字符串池中寻找内容相同的对象，并返回引用，若找不到会在字符串池中创建并返回；
 *   jdk1.7后：inter()方法在字符串池中找不到的话，若堆中存在和其值相同的String对象，会在字符串池中留下这个
 *   堆对象的引用，并返回；也就是说若此后再以直接赋值的方式创建这个值的String对象都会在池中发现这个引用并
 *   返回（指向了堆中的String对象），而不会再创建常量对象然后返回常量对象的引用了
 */
public class Difference {

    public static void main(String[] args) {

        Difference difference = new Difference();

        //验证直接赋值和用构造器String(String)构建指向不同的对象，以及直接赋值指向的是字符串池中的对象
        difference.d1();

        //验证修改操作实际上相当于以直接赋值的方法在字符串池创建String对象
        difference.d2();

        //验证两个用构造器String(String)创建的“hello”，在堆中的String对象引用不同，但是在字符串池中的引用相同
        difference.d3();

        //验证intern()方法的调整
        difference.d4();

    }

    public void d1(){

        String s1 = new String("hello");
        String s2 = "hello";
        System.out.println("s1 和 s2 指向同一个对象："+(s1 == s2));//false
        System.out.println("s1在字符串池中的引用和s2的引用相同："+(s1.intern() == s2));//true
        System.out.println("==========================================");

    }

    public void d2(){

        String s1 = "hello1";
        String s2 = "hello1";
        System.out.println("s1 和 s2 的引用相同："+(s1 == s2));//true

        s1 = "he";
        System.out.println("修改后的s1 和 s2（修改前的s1） 的字符串池引用相同："+(s1.intern() == s2.intern()));//false
        System.out.println("==========================================");

    }

    public void d3(){

        String s1 = new String("hello2");
        String s2 = new String("hello2");

        System.out.println("s1 和 s2 指向的是堆中的同一个对象："+(s1 == s2));//false
        System.out.println("s1 和 s2 在字符串池中的引用相同："+(s1.intern() == s2.intern()));//true
        System.out.println("==========================================");

    }

    public void d4(){

        //使用intern()方法情况一：在池中没有相应常量的情况下调用

        //用这种方式s1会在堆中创建String对象，在字符串池中不会创建常量对象
        String s1 = new String("yy") + new String("ds");

        //由于此时池中没有yyds常量，调用intern()方法会在池中留下堆中yyds对象的地址
        String s2 = s1.intern();

        System.out.println("s1在池中的引用实际上就是对堆中对象的引用："+(s1 == s2));//true

        //由于池中已经留下了yyds堆对象的引用，所以试图创建yyds常量对象时，直接返回yyds堆对象的引用
        //也就是说此时不管是s1还是s1.intern()都是指向堆中的对象
        String s3 = "yyds";//s3指向的是堆中的yyds对象
        System.out.println("s3 和 s1 指向同一个对象："+(s1 == s3));//true


        //使用intern()方法情况二：在池中已经存在相应常量的情况下调用

        String s4 = new String("oxo");

        //由于池中有oxo常量对象，调用intern()方法时返回这个对象的引用
        String s5 = s4.intern();

        //所以s4指向堆中对象，s5指向池内对象
        System.out.println("s4 和 s5 指向同一个对象："+(s4 == s5));//false
        System.out.println("==========================================");
    }

}

