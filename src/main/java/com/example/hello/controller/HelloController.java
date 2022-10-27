package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class HelloController {
    //
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello world";
    }

    @GetMapping(value = "/name")
    public String getName() {
        return "Eungjun";

    }

    @GetMapping(value = "/variable1/{variable}")
    public String getvariable1(@PathVariable String variable) {
        return variable;
    }

    @GetMapping(value = "/variable2/{variable}")
    public String getvariable2(@PathVariable("variable") String var) {
        return var;
    }

    //http://localhost:8080/api/v1/get-api/request1?name=dmdwns&email=dmdwns@dmdwns.com&organization=멋사
    @GetMapping(value = "/request1") // request1을 받는 getendpoint
    public String getRequestParam1( // 3개의 param값 받기
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization
    ) {
        return name + " " + email + " " + organization; // return하게 하기
    }

    @GetMapping(value = "/request2")
    public String getRequestParam2 (@RequestParam Map<String, String> param){
        param.entrySet().forEach((map)-> {
            System.out.printf("key:%s value:%s\n",
            map.getKey(),map.getValue());
        });
        return "request2가 호출 완료 되었습니다.";

    }
}
