package com.example.hello.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BasicController {

    @GetMapping("/api/hello1")
    public String hello1() {

        log.info("hello1 요청이 들어왔습니다.");return "hello";
    }

    @GetMapping("/api/hello2")
    public String hello2(@RequestParam String param) {

        log.info("hello2 요청이 들어왔습니다.");return param;
    }
}