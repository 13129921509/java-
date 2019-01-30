package com.springcloud.ticketingsystem.test;

import com.springcloud.ticketingsystem.resposity.PersonRepository;
import com.springcloud.ticketingsystem.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test_0 {
    @Autowired
    private PersonService service;
    @Autowired
    private PersonRepository repository;
    @Test
    public void test(){
        //getAll();
        deletePersonByName("cai2");
    }

    public void getAll(){
        repository.getAll().forEach(v -> System.out.println(v.toString()));
    }

    @Transactional
    public void deletePersonByName(String name){
        service.deletePersonByName(name);
        getAll();
    }
}
