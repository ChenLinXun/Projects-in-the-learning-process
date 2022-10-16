package com.feng.mapper;

import com.feng.pojo.User;
import junit.framework.TestCase;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserMapperTest extends TestCase {

    public void testQueryUsers() {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //获取Mapper，注意，Mapper的id默认是首字母小写，除非进行：@Component注解配置
        UserMapper userMapper = (UserMapper) context.getBean("userMapper");

        List<User> users = userMapper.queryUsers();
        System.out.println(users);

    }
}
