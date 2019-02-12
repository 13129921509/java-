package com.springboot.demo.controller;

import com.springboot.demo.entity.User;
import com.springboot.demo.mapper.ShipmentDetailMapper;
import com.springboot.demo.service.ShipmentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class ShipmentDetailController {
    @Autowired
    ShipmentDetailService service;

    @GetMapping("shipment/{name}")
    public String getItemCode(@PathVariable("name") String name){
      //  System.out.println(request.getParameter("sex"));
//        System.out.println(sessionsex);
        return service.getItmeCodeByItemCode(name);
    }

//    @GetMapping(value = "enter/{id}")
//    public User entry(@PathVariable("id") String id){
//        service.
//    }
}
