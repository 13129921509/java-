package com.ittx.springboot.dao;

import com.ittx.springboot.annotation.After;
import com.ittx.springboot.annotation.Aspect;
import com.ittx.springboot.annotation.Before;
import com.ittx.springboot.annotation.Pointcut;
import com.ittx.springboot.inface.IUserDao;
@Aspect
public class UserDao implements IUserDao {

    @Pointcut(value = "com.ittx.springboot.proxy.Show.show")
    public void show(){}

    @Override
    @After
//    @Before
    public void save() {
        System.out.println("目标对象save方法");
    }
}
