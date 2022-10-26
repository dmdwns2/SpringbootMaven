package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/get-api")
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "Hello world";
    }

    @GetMapping(value = "/name")
    public String getName(){
        return "Eungjun";

    }

    @GetMapping(value = "/variable1/{variable}")
    public String getvariable1(@PathVariable String variable){
        return variable;
    }

    @GetMapping(value = "/variable2/{variable}")
    public String getvariable2(@PathVariable("variable") String var){
        return var;
    }
}
