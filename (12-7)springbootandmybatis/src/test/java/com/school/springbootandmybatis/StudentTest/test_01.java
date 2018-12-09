package com.school.springbootandmybatis.StudentTest;

import com.school.springbootandmybatis.Dao.StudentDAO;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test_01 {
    @Autowired
    StudentDAO studentDAO;
    @Test
    public void test_01(){
        String name = studentDAO.getStudent("3","cai3").getStudentName();
        System.out.println(name);
    }
    //@Transactional能够让事务回滚
    @Test
    @Transactional(rollbackFor = {TooManyResultsException.class})
    public void test_02(){
        studentDAO.InsertStudent("ajian");
        System.out.println(studentDAO.getStudent(null,"ajian").getStudentId());
    }
}
