package com.tutorial.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// class contoh test controller untuk membuat api HELLO WORLD
@RestController
public class TestController {

    @RequestMapping(value = "/hello")
    public String getHelloName(@RequestParam String name){
        return "Hello " + name;
    }
}
