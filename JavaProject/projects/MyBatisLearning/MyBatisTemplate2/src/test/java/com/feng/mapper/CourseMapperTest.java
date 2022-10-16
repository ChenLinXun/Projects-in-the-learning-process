package com.feng.mapper;

import com.feng.pojo.Course;
import com.feng.utils.MyBatisUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseMapperTest {

    @Test
    public void queryCourseWithStu() {

        CourseMapper courseMapper = MyBatisUtil.getMapper(CourseMapper.class);
        Course course = courseMapper.queryCourseWithStu(1);
        System.out.println(course);

    }

    @Test
    public void queryCourseWithStu2() {

        CourseMapper courseMapper = MyBatisUtil.getMapper(CourseMapper.class);
        Course course = courseMapper.queryCourseWithStu(2);
        System.out.println(course);

    }
}