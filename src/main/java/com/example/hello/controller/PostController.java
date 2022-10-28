package com.example.hello.controller;


import com.example.hello.dao.UserDao;
import com.example.hello.domain.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
@Slf4j
public class PostController {


    //  http://localhost:8080/api/v1/post-api/domain
    // Body
    // {
    //  "name":"dmdwns",
    //  "email" : dmdwns@dmdwns.com
    //}
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        log.info("postExample 요청이 들어왔습니다.");
        return "hello Post API";
    }
    // http://localhost:8080/api/v1/post-api/member1
    // Body
    // {
    //  "name":"dmdwns",
    //  "email" : "dmdwns@dmdwns.com",
    //  "age" : 36,
    //  "IsMarried" : 1
    //}
    @PostMapping(value = "/member1")
    public String postMember(@RequestBody Map<String, Object> postData) { // Object로 하는이유 어떤 타입으로 들어올 지 서버 입장에서는 몰라서
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        log.info("postMember 요청이 들어왔습니다.");
        return sb.toString();

    }
    @PostMapping(value = "/member2")
    public MemberDto postMember2(@RequestBody MemberDto memberDto) {

        log.info("postMember2 요청이 들어왔습니다.");
        return memberDto;
    }

    @PostMapping(value = "/add1")
    public MemberDto add1(@RequestBody MemberDto memberDto){
        UserDao userDao = new UserDao(memberDto);

    }

}
