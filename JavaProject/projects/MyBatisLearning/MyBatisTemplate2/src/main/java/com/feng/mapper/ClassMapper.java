package com.feng.mapper;

import com.feng.pojo.Clazz;

public interface ClassMapper {

    /**
     * 使用连接查询：
     * 根据班别查询班级信息（包括关联学生）
     * @param className
     * @return
     */
    Clazz queryClassWithStu(String className);

    /**
     * 使用子查询
     * 根据班别查询班级信息（包括关联学生）
     * @param className
     * @return
     */
    Clazz queryClassWithStu2(String className);

}
