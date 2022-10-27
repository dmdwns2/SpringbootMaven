package com.example.hello.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    //  http://localhost:8080/api/v1/post-api/domain
    //{
    //  "name":"dmdwns",
    //  "email" : dmdwns@dmdwns.com
    //}
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "hello Post API";
    }
}
