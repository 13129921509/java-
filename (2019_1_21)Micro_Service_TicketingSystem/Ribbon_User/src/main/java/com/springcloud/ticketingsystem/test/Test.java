package com.springcloud.ticketingsystem.test;


import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

public class Test {
    //以下是使用继承的方式实现熔断功能
    static class UserCommand extends HystrixCommand {
        private RestTemplate restTemplate;
        private Long id;
        protected UserCommand(Setter setter,RestTemplate restTemplate,long id) {
            super(setter);
            this.restTemplate = restTemplate;
            this.id = id;
        }

        @Override
        protected Object run() throws Exception {
            return restTemplate.getForObject("http://USER-REGISTER-SERVER/user/{1}",Object.class,id);
        }

    }

    public static void main(String[] args) {
        new UserCommand(null, new RestTemplate(),2L).observe();//hot observable 每次被订阅的时候触发执行
        new UserCommand(null, new RestTemplate(),2L).toObservable();//cold observable 所有的订阅者都触发的时候才执行
    }
    //以下为使用注解的方式来定义熔断器
    @Autowired
    RestTemplate restTemplate;

    @com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
    public Object getUserById(Long id){
        return restTemplate.getForObject("http://USER-REGISTER-SERVER/user/{1}",Object.class,id);
    }

    @com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
    public Future<Object> getUserById2(Long id){
        return new AsyncResult<Object>() {
            @Override
            public Object invoke() {
                return restTemplate.getForObject("http://USER-REGISTER-SERVER/user/{1}",Object.class,id);
            }
        };
    }


}
