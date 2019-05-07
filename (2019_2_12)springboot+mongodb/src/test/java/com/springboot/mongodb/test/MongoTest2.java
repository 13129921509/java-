package com.springboot.mongodb.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.springboot.mongodb.domain.ExceptionResponse;
import com.springboot.mongodb.domain.PrintDataResponse;
import com.springboot.mongodb.entity.PrintData;
import com.springboot.mongodb.repository.PrintDataRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MongoTest2 {
    @Autowired
    PrintDataRepository printDataRepository;
    @Autowired
    MongoClient client;
    @Autowired
    MongoTemplate template;
    @Before
    public void before(){

    }
    @Test
    public void process() throws IOException {
        try{
            ObjectMapper JSON = new ObjectMapper();
            ;
            for (PrintData data : printDataRepository.findAll(Sort.by("created"))){
                System.out.println(data);
                PrintDataResponse rsp = JSON.readValue(data.getPrintDate(),PrintDataResponse.class);
                if (!printDataRepository.existsById(data.id)){
                    template.insert(rsp,"print_data_rsp");
                }else{
                    int a = 3/0;
                }
            }
        }catch (Exception e){
            template.insert(new ExceptionResponse(
                    () ->{
                StringBuffer buffer = new StringBuffer();
                for (StackTraceElement stackTraceElement : e.getStackTrace()){
                    buffer.append("\r\n\t").append(stackTraceElement);
                }
                return buffer.toString();
            },
                    Calendar.getInstance().getTime().toString(),
                    e.getClass().toString(),
                    e.toString()),
                    "logs_exception");
        }


    }


}

