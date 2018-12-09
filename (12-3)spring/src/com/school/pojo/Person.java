package com.school.pojo;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;

    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void init_person(){
        System.out.println("==================================================");
    }

    public void destory_person(){
        System.out.println("person已销毁");
        System.out.println("==================================================");
    }
}
