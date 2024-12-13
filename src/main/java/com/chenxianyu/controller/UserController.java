package com.chenxianyu.controller;

import com.chenxianyu.model.enity.User;
import com.chenxianyu.model.vo.Reslut;
import com.chenxianyu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/getAllUser")
    public Reslut getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping("/delectUser")
    public Reslut delectUser(@RequestBody User user){
        return userService.delectUser(user);
    }

    @PostMapping("/addUser")
    public Reslut addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping("/updateUser")
    public Reslut updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
}
