package com.ittx.springboot.config;

import com.ittx.springboot.dao.UserDao;
import com.ittx.springboot.inface.IUserDao;
import com.ittx.springboot.proxy.ProxyFactory;
import com.ittx.springboot.server.MyAop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean("user_proxy")
    public IUserDao getProxyInstance(){
        return (IUserDao) ProxyFactory.getProxyInstance(new UserDao(),new MyAop());
    }
}
