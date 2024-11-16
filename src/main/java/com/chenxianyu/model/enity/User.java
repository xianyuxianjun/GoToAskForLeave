package com.chenxianyu.model.enity;

import lombok.Data;

@Data
public class User {
    private String userid;
    private String fullname;
    private String email;
    private String password;
    private String telephone;
    private String role;
}
