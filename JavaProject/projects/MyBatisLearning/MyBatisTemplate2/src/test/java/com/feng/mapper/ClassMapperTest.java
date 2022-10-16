package com.feng.mapper;

import com.feng.pojo.Clazz;
import com.feng.utils.MyBatisUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClassMapperTest {

    @Test
    public void queryClassWithStu() {
        ClassMapper classMapper = MyBatisUtil.getMapper(ClassMapper.class);
        Clazz clazz = classMapper.queryClassWithStu("Java1班");
        System.out.println(clazz);
    }

    @Test
    public void queryClassWithStu2() {
        ClassMapper classMapper = MyBatisUtil.getMapper(ClassMapper.class);
        Clazz clazz = classMapper.queryClassWithStu2("Java2班");
        System.out.println(clazz);
    }
}