package com.example.hello.controller;


import com.example.hello.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    //  http://localhost:8080/api/v1/post-api/domain
    // Body
    // {
    //  "name":"dmdwns",
    //  "email" : dmdwns@dmdwns.com
    //}
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "hello Post API";
    }
    // http://localhost:8080/api/v1/post-api/member1
    @PostMapping(value = "/member1")
    public String postMember(@RequestBody Map<String, Object> postData) { // Object로 하는이유 어떤 타입으로 들어올 지 서버 입장에서는 몰라서
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();

    }
    // http://localhost:8080/api/v1/post-api/member2
    @PostMapping(value = "/member2")
    public MemberDto postMember2(@RequestBody MemberDto memberDto) {
        return memberDto;
    }
}
