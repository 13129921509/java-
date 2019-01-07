package com.school.springbootandmybatis.Dao;

import com.school.springbootandmybatis.entity.Student;
import com.school.springbootandmybatis.mapper.StudentMapper;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Component
public interface StudentDAO{
    Student getStudent(String id,String name);

    void InsertStudent(String name);
}
