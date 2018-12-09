package com.school.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(value = "com.school.pojo")
public class MyConfig {
    Person person;
    @Bean(value = "person",initMethod = "init_person",destroyMethod = "destory_person")
    public Person getPerson() {
        this.person = new Person();
        person.setName("cai");
        return person;
    }


}
