package com.chenxianyu.controller;

import com.chenxianyu.model.dto.LoginDto;
import com.chenxianyu.model.vo.Reslut;
import com.chenxianyu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginContorller {
    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public Reslut login(@RequestBody LoginDto loginDto){
        return loginService.login(loginDto);
    }
}
