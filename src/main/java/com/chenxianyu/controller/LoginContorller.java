package com.chenxianyu.controller;

import com.chenxianyu.model.dto.LoginDto;
import com.chenxianyu.model.enity.User;
import com.chenxianyu.model.vo.Reslut;
import com.chenxianyu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LoginContorller {

    @Autowired
    private LoginService loginService;

    /**
     * 处理登录请求
     * @param loginDto 登录信息
     * @return 登录结果
     */
    @ResponseBody
    @PostMapping("/login")
    public Reslut login(@RequestBody LoginDto loginDto){
        return loginService.login(loginDto);
    }
}