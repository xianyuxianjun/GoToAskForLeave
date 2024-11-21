package com.chenxianyu.controller;

import com.chenxianyu.model.dto.RegisterDto;
import com.chenxianyu.model.vo.Reslut;
import com.chenxianyu.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public Reslut Register(@RequestBody RegisterDto registerDto){
        return registerService.segister(registerDto);
    }
}
