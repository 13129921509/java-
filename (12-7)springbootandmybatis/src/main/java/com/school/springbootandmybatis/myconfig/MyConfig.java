package com.school.springbootandmybatis.myconfig;

import com.school.springbootandmybatis.Dao.StudentDAO;
import com.school.springbootandmybatis.Dao.StudentDaoImpl;
import com.school.springbootandmybatis.entity.Student;
import com.school.springbootandmybatis.mapper.StudentMapper;
import com.school.springbootandmybatis.mapper.StudentProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.school.springbootandmybatis")
public class MyConfig {
    @Bean
    public StudentDAO getStudentDAO(){
        return new StudentDaoImpl();
    }

//    @Bean
//    public StudentMapper getStudentMapper(){
//        return new StudentProvider();
//    }
}
