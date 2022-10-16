package com.feng.mapper;

import com.feng.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mvc.xml","classpath:spring-context.xml","classpath:spring-mybatis.xml"})
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void selectAllByUserName() {
        User user = userMapper.selectAllByUserName("zhangsan");
        System.out.println(user);
    }
}