package com.school.springbootandmybatis.mapper;

import com.school.springbootandmybatis.entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
public interface StudentMapper{
    @SelectProvider(type = StudentProvider.class,method = "getStudent")
    @Results({
            @Result(property = "studentId" , column = "student_id"),
            @Result(property = "studentName" , column = "student_name")
    })
    Student getStudent(@Param("id")String id,@Param("name")String name);


    @InsertProvider(type = StudentProvider.class,method = "insertStudent")
    void insertStudent(@Param("name")String name);
}
