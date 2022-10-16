package JUnit;
import org.junit.jupiter.api.Test;
/*
 * JUnit基本介绍：
 * 1.JUnit是一个Java语言的单元测试框架
 * 2.多数Java的开发环境都已经集成了JUnit作为单元测试的工具
 */
public class JUnit_ {

    public static void main(String[] args) {
        //传统测试方法：
        new JUnit_().A();
        new JUnit_().B();
    }

    //使用JUnit单元测试框架：在方法上添加@Test，按Alt+回车，选择JUnit5.4
    @Test
    public void A(){
        System.out.println("调用了A方法");
    }

    @Test
    public void B(){
        System.out.println("调用了B方法");
    }
}
