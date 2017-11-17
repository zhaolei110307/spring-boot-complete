package com.zhaolei.spring_boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${name}")
    private String name;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String say(){
        return name;
    }

}
