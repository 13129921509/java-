package com.ittx.springcloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {
    @RequestMapping("/health1")
    @ResponseBody
    public Map getHealth(){
        Map map = new HashMap();
        map.put("name","cai");
        return map;
    }
}
