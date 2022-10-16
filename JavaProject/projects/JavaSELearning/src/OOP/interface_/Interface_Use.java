package OOP.interface_;

/*
 * 1. 接口不能实例化，并且没有构造器
 * 2. 接口中的方法必须是public方法，可以不加public修饰
 * 3. 接口中的方法默认是抽象方法，没有方法体，可以不加abstract修饰
 * 4. jdk8以前接口中只能有抽象方法，不能有普通方法，也就是不能有方法的实现 
 *    jdk8和jdk8以后，接口中可以有普通方法和静态方法，但普通方法必须加default修饰符修饰 
 *   （default有违约的意思）
 * 5. 普通类实现接口必须将接口的所有方法实现，抽象类实现接口可以不实现接口的方法
 * 6.类实现了接口后，继承了接口的所有属性和方法
 * 7. 一个类可以同时实现多个接口，接口名之间用逗号隔开
 * 8. 接口中的属性默认必须是public static final的，所以必须赋初始值，这几个修饰符可以省略不写
 * 9.接口中属性的调用方式是：接口名.属性名
 * 10.接口不能继承extends其他的类，但是可以继承extends多个其他的接口
 * 11.接口的访问权限只能是public（公共）的和default（默认）的，这和类一样
 *
 */

public class Interface_Use {

    public static void main(String[] args) {

        MysqlDB mysqlDB = new MysqlDB();
        OracleDB oracleDB = new OracleDB();
        UseDB(mysqlDB);
        UseDB(oracleDB);

    }

    public static void UseDB(DBInterface dbInterface){
        System.out.println("=========================");
        dbInterface.connect();
        System.out.println("对数据库进行了增删改查工作");
        dbInterface.close();
        System.out.println("=========================");
    }
}

interface DBInterface{

    void connect();

    void close();

}

class MysqlDB implements DBInterface{

    @Override
    public void connect() {
        System.out.println("Mysql数据库连接了.....");
    }

    @Override
    public void close() {
        System.out.println("Mysql数据库连接关闭了.....");
    }
}

class OracleDB implements DBInterface{

    @Override
    public void connect() {
        System.out.println("Oracle数据库连接了.....");
    }

    @Override
    public void close() {
        System.out.println("Oracle数据库连接关闭了.....");
    }
}