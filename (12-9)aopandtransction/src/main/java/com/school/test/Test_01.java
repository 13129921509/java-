package com.school.test;

import com.school.Service.StudentService;
import com.school.Service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:applicationContext-transction.xml"})
public class Test_01 {
    @Resource(name = "userService1")
    UserService userService;
    @Autowired
    StudentService studentService;
//    @Test
//    public void test_01(){
//        userService.save();
//    }

    @Test
    public void test_02(){
        studentService.transcation(3,4);
    }
}
