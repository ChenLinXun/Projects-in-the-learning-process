package com.feng.mapper;

import com.feng.pojo.Course;

public interface CourseMapper {

    /**
     * 连接查询：
     * 根据课程id查询课程，包括本课程的所有学生
     * @param courseId
     * @return
     */
    Course queryCourseWithStu(int courseId);

    /**
     * 子查询：
     * 根据课程id查询课程，包括本课程的所有学生
     * @param courseId
     * @return
     */
    Course queryCourseWithStu2(int courseId);

}
