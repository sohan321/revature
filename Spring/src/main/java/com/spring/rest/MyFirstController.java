package com.demo.spring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/test")
    public String sayHotReload() {
        return "Hot Reload!";
    }

}
