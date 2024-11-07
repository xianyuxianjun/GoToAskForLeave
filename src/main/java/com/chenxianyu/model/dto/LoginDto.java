package com.chenxianyu.model.dto;

import lombok.Data;

@Data
public class LoginDto {
    private String userId;
    private String username;
    private String password;
    private String role;
}
