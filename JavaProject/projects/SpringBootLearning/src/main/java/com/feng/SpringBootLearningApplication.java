package com.feng;

import com.feng.pojo.Car;
import com.feng.pojo.Person;
import com.feng.pojo.Pet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.UnsupportedEncodingException;

//@ServletComponentScan(basePackages = "com.feng") //原生组件注入
@SpringBootApplication
public class SpringBootLearningApplication {
    public static void main(String[] args) throws UnsupportedEncodingException {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootLearningApplication.class, args);

        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        Person person01 = run.getBean("person01", Person.class);
        Person person02 = run.getBean("person01", Person.class);
        //无论获取多少次都是IOC容器中的那个单例
        System.out.println("两个person同一个：" + (person01 == person02));

        Pet pet1 = person02.getPet();
        Pet pet2 = run.getBean("tom", Pet.class);
        //如果 @Configuration(proxyBeanMethods = true) 则从user01中获取的就是IOC容器的那个单例pet，否则为false
        System.out.println("两个pet同一个：" + (pet1 == pet2));

        //根据类型获取组件名
//        String[] s = run.getBeanNamesForType(Person.class);
//        for (String s1 : s) {
//            System.out.println(s1);
//        }
//        DBHelper bean = run.getBean(DBHelper.class);
//        System.out.println(bean);

        //导入spring配置文件创建的组件
        boolean haha = run.containsBean("haha");
        boolean hehe = run.containsBean("hehe");
        System.out.println("haha: " + haha);
        System.out.println("hehe: " + hehe);

        //配置绑定
        Car bean = run.getBean(Car.class);
        System.out.println(bean);
    }
}
