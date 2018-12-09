package com.school.test;

import com.school.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

import javax.annotation.Resource;

public class Test_01 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(User.class);
        context.refresh();
        User user1 = (User) context.getBean("user1");
        System.out.println(user1.getName());
    }

}
