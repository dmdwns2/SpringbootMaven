package com.example.hello.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor // 생성자를 생성안해도됨
@Getter //getter를 생성 안해줘도 됨
public class UserRequestDto {
    private String id;
    private String name;
    private String password;

}
