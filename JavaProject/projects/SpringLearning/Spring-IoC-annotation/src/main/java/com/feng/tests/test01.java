package com.feng.tests;

import com.feng.beans.Student;
import com.feng.beans.Teacher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试@Component、@Scope、@Lazy、@PostConstruct、@PreDestroy、@Autowired、@Resource注解
 */
public class test01 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Student stu = (Student) context.getBean("stu");
        System.out.println(stu);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Student stu2 = (Student) context.getBean("stu");
        System.out.println(stu==stu2);

        Teacher teacher = (Teacher) context.getBean("teacher");
        System.out.println(teacher);
    }
}
