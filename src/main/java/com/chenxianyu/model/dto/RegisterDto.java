package com.chenxianyu.model.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String username;
    private String password;
    private String fullName;
    private String role;
    private String sex;
}
