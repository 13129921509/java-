package com.school.springbootandmybatis.Dao;

import com.school.springbootandmybatis.entity.Student;
import com.school.springbootandmybatis.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class StudentDaoImpl implements StudentDAO{
    @Autowired
    StudentMapper studentMapper;


    @Transactional
    @Override
    public Student getStudent(String id,String name) {
        Student s = studentMapper.getStudent(id,name);
        return s;
    }

    @Override
    public void InsertStudent(String name) {
        studentMapper.insertStudent(name);
    }
}
