package com.feng.config;

import com.feng.pojo.Car;
import com.feng.pojo.Person;
import com.feng.pojo.Pet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.util.Date;

/**
 * 1. 配置类里面使用@Bean标注在方法上，给容器注册组件，默认也是单实例的
 * 2. 配置类本身也是组件
 * 3. proxyBeanMethods：代理bean的方法：
 *      Full(proxyBeanMethods = true)
 *          全模式，存在组件依赖时使用，确保方法调用得到的是之前在容器中注册的实例
 *      Lite(proxyBeanMethods = false)
 *          轻量级模式，外部调用配置类方法时不会检查容器中是否存在返回类型的实例，SpringBoot启动快；单单注册组件，没有组件依赖时使用
 * 4. 用@Import：
 *      不用写配置类方法，自动在容器中创建组件，组件的id就是全类名
 * 5. 用@ImportResource("classpath:bean.xml")：
 *      导入Spring的配置文件
 * 6. @EnableConfigurationProperties + ConfigurationProperties：
 * 	    配置绑定，读取properties文件中的内容，封装到 JavaBean中，避免使用java代码过于麻烦
 */
@Configuration(proxyBeanMethods = true) //告诉SpringBoot这是一个配置类 == 配置文件
//@Import(value = {Person.class, Pet.class, DBHelper.class})
@ImportResource("classpath:bean.xml")
// 1. 开启Car配置绑定功能
// 2. 把这个Car组件自动注册到容器中
@EnableConfigurationProperties(Car.class)
public class MyConfig {

    @Bean("tom")//给容器中添加组件。 方法名即为组件id，返回类型即为组件类型，返回值即为组件在容器中的实例
    public Pet pet01(){
        return new Pet("小柴");
    }

    /**
     * 外部无论对配置类中的这个组件注册方法调用多少次，获取的都是容器中的单例对象
     */
    //条件装配：容器中有名字为 tom 的组件才注册组件，注意装配顺序，被依赖的组件放前面
    @ConditionalOnBean(name = "tom")
    @Bean
    public Person person01(){
        Person person = new Person("张三", 18,new Date(),null);
        person.setPet(pet01()); //组件依赖
        return person;
    }

}
