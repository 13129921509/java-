package com.ittx.springboot.server;

import org.springframework.stereotype.Component;

@Component
public class MyAop {
    public void begin(){
        System.out.println("开启事务/异常");
    }

    public void commite(){
        System.out.println("提交事务/关闭");
    }
}
