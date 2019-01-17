package com.ittx.springboot.inface;

import com.ittx.springboot.annotation.Aspect;
import com.ittx.springboot.annotation.Pointcut;

@Aspect
public interface IUserDao {
    public void save();
}
