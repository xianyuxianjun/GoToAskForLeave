package com.chenxianyu.controller;

import com.chenxianyu.model.dto.LoginDto;
import com.chenxianyu.model.enity.User;
import com.chenxianyu.model.vo.Reslut;
import com.chenxianyu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginContorller {
    @Autowired
    private LoginService loginService;
    @ResponseBody
    @PostMapping(value = "/login")
    public Reslut login(@RequestBody LoginDto loginDto){
        return Reslut.error("asdasd");
    }
}
