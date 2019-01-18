package com.ittx.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.ArrayList;

@Controller
public class PersonController {
    @RequestMapping(value = "/getAge", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAge(){
        ModelAndView view = new ModelAndView("age");
        view.addObject("books",new ArrayList<String>());
        return view;
    }
}
