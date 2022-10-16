package com.feng.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Clazz {
    private int classId;
    private String className;
    private String classDesc;

    //存储关联的学生
    private List<Student> stus;
}
