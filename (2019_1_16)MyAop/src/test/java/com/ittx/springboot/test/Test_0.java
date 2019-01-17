package com.ittx.springboot.test;

import com.ittx.springboot.inface.IUserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test_0 {
    @Autowired
    IUserDao userDao;
    @Test
    public void test_1(){
        System.out.println(userDao.getClass());
        userDao.save();
    }
}
