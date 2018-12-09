package com.school.test;


import com.school.pojo.MyConfig;
import com.school.pojo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test_02 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Person person = (Person) context.getBean("person");
        System.out.println(person.getName());
        person.destory_person();
    }
}
