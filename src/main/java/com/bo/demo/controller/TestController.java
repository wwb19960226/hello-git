package com.bo.demo.controller;


import com.bo.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("/test01")
    public String test01(){
        String t1 = "0";
        String s = testService.testService01();
        System.out.println(s);
        return s;
    }

}
