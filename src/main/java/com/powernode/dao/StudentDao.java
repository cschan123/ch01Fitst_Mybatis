package com.powernode.dao;

import com.powernode.domain.Student;

public interface StudentDao {
    //查询一个学生
    Student selectStudentbyID(Integer id);
    //查询所有学生信息
    Student studentList();

    //添加学生,返回值是影响数据库的行数
    int insertStudent(Student student);

}
