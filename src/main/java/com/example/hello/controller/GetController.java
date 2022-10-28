package com.example.hello.controller;

import com.example.hello.domain.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
@Slf4j
public class GetController {
    //
    @RequestMapping(value = "/hello", method = RequestMethod.GET)

    public String hello() {
        log.info("hello로 요청이 들어왔습니다.");
        return "Hello world";
    }

    @GetMapping(value = "/name")

    public String getName() {
        log.info("getName으로 요청이 들어왔습니다.");
        return "Eungjun";

    }

    @GetMapping(value = "/variable1/{variable}")
    public String getvariable1(@PathVariable String variable) {
        log.info("getvariable1로 요청이 들어왔습니다."); return variable;
    }

    @GetMapping(value = "/variable2/{variable}")
    public String getvariable2(@PathVariable("variable") String var) {
        log.info("getvariable2로 요청이 들어왔습니다.");
        return var;
    }

    //http://localhost:8080/api/v1/get-api/request1?name=dmdwns&email=dmdwns@dmdwns.com&organization=멋사
    @GetMapping(value = "/request1") // request1을 받는 getendpoint
    public String getRequestParam1( // 3개의 param값 받기
                                    @RequestParam String name,
                                    @RequestParam String email,
                                    @RequestParam String organization
    ) {
        log.info("getRequestParam1으로 요청이 들어왔습니다.");
        return name + " " + email + " " + organization; // return하게 하기
    }


    //http://localhost:8080/api/v1/get-api/request2?name=dmdwns&email=dmdwns@dmdwns.com&organization=멋사&age=29
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        param.entrySet().forEach((map) -> {
            System.out.printf("key:%s value:%s\n",
                    map.getKey(), map.getValue());
        });
        log.info("getRequestParam2으로 요청이 들어왔습니다.");
        return "request2가 호출 완료 되었습니다.";

    }

    //http://localhost:8080/api/v1/get-api/request3?name=dmdwns&email=dmdwns@dmdwns.com&organization=멋사&age=29
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDto) {

        log.info("getRequestParam3으로 요청이 들어왔습니다.");
        return memberDto.toString();
    }
}
