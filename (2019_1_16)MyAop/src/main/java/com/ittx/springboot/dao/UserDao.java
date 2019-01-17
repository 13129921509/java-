package com.ittx.springboot.dao;

import com.ittx.springboot.inface.IUserDao;

public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("目标对象save方法");
    }
}
