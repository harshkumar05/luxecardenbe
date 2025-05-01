package com.pp.luxecardenbe.controllers.dummy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping("Hello")
    public String helloWorld(){
        return "Hello World";
    }
}
