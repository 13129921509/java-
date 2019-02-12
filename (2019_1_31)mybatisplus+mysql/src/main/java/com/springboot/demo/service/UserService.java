package com.springboot.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.springboot.demo.entity.User;
import com.springboot.demo.mapper.UserMapper;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    Logger logger = Logger.getLogger(UserService.class);
    @Autowired
    UserMapper mapper;

    public String getUsersetVersion(Integer id){
        LambdaQueryWrapper<User> wrapper= new LambdaQueryWrapper<User>();
        String myVersion = mapper.getVersion(wrapper.eq(User::getId,id));
        return myVersion;
    }

    public String setUsersetVersion(Integer id,String except){
        LambdaUpdateWrapper<User> wrapper= new LambdaUpdateWrapper<User>();
//        boolean myVersion = Boolean.parseBoolean(mapper.getVersion(wrapper.eq(User::getId,id)));
        if(!except.equals(getUsersetVersion(id))){
            logger.info(Thread.currentThread().getName()+"没有获得锁");
            return "没有获得锁";
        }else{
//            mapper.setVersion(wrapper.eq(User::getId,id));
            mapper.update(new User(),wrapper
                    .set(User::getVersion,Thread.currentThread().getName())
                    .eq(User::getId,id));
            logger.info(Thread.currentThread().getName()+"成功获得锁");
            return "成功获得锁";
        }
    }
}
