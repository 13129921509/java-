package com.ittx.springboot.controller;

import com.ittx.springboot.Entity.Person;
import com.ittx.springboot.send.PersonRegisterSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class PersonController {
    @Autowired
    private PersonRegisterSender sender;

    @RequestMapping(value = "/registerPerson",method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public void registerPerson(@RequestBody  Map<String,List<Map<String,String>>> data){
        System.out.println(data.get("data"));
        List<Map<String,String>> list = data.get("data");
        for(int i = 0 ; i < list.size();i++){
            sender.sendMessage(new Person(String.valueOf(list.get(i).get("username")),list.get(i).get("email")));
        }
    }
}
