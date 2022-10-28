package com.example.hello.controller;

import com.example.hello.dao.UserDao;
import com.example.hello.domain.User;
import com.example.hello.domain.dto.UserRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userdao) {
        this.userDao = userdao;
    }
    @PostMapping("")
    public ResponseEntity<Integer> add(@RequestBody UserRequestDto userRequestDto){
        User user = new User(userRequestDto.getId(), userRequestDto.getName(), userRequestDto.getPassword());
        return ResponseEntity
                .ok()
                .body(userDao.add(user));
    }
}
