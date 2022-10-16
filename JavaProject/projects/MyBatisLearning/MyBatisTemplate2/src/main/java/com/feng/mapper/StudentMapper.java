package com.feng.mapper;

import com.feng.pojo.Student;

import java.util.List;

public interface StudentMapper {

    /**
     * 根据cid查询学生所有信息
     * @param cid
     * @return
     */
    List<Student> listStudentsByCid(int cid);

    /**
     * 根据课程id查询学生所有信息
     * @param courseId
     * @return
     */
    List<Student> listStudentsByCourseId(int courseId);

}
