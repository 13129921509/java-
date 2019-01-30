package com.example.demo.test;

import com.alibaba.fastjson.JSON;
import com.example.demo.controller.UserController;
import com.example.demo.entity.User;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class Test_0 {

    @Autowired
    UserController controller;
    @Before
    public void before(){
        controller.setUsers(new User("cai","22","男"));
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }
    MockMvc mockMvc;
    @Test
    public void test() throws Exception {
        RequestBuilder request = null;
        //controller.setUsers(new User("cai","22","男"));
//        request = get("/cai/");
//        mockMvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("")));

        request = post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(new User("kk","11","男")));
//                .param("name","kk")
//                .param("sex","男")
//                .param("age","11");
        mockMvc.perform(request)
                .andExpect(content().string(equalTo("success")))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        //--------------put----------------
        request = put("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(new User("kk","50","女")));
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        request = get("/kk/");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
