package com.springboot.mongodb.test;

import com.springboot.mongodb.entity.Book;
import com.springboot.mongodb.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoTest {
    @Autowired
    BookRepository repository;

    @Before
    public void setup(){

    }
    @Test
    public void test(){
        repository.save(new Book("spring微服务","蔡子文","['技术','科普']","200"));
        System.out.println(repository.findAll().size());
    }
}
