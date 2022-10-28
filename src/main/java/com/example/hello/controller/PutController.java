package com.example.hello.controller;


import com.example.hello.domain.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
@Slf4j
public class PutController {


    @PutMapping(value = "/member3")
    public ResponseEntity postMember3(@RequestBody MemberDto memberDto) {
        log.info("postMember3 요청이 들어왔습니다.");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDto);
    }

}
