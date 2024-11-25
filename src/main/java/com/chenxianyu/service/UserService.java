package com.chenxianyu.service;

import com.chenxianyu.mapper.UserMapper;
import com.chenxianyu.model.enity.User;
import com.chenxianyu.model.vo.Reslut;
import com.chenxianyu.utils.MD5Encryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public Reslut getAllUser() {
        List<User> users = userMapper.selectAllUser();
        return Reslut.succeed(users);
    }

    public Reslut delectUser(User user) {
        int i = userMapper.delectUserById(user.getUserId());
        if (i>0){
            return Reslut.succeed();
        }
        return Reslut.error("删除失败");
    }

    public Reslut addUser(User user) {
        User user1 = userMapper.selectUserByEmail(user.getEmail());
        if (user1 != null){
            return Reslut.error("用户已存在");
        }
        Random random = new Random();
        long l = random.nextInt();
        user.setRole("管理员");
        user.setPassword(MD5Encryptor.encryptToMD5("123456"));
        user.setUserId("A"+l);
        int i = userMapper.addUser(user);
        if (i>0){
            return Reslut.succeed();
        }
        return Reslut.error("添加失败");
    }


    public Reslut updateUser(User user) {
        int i = userMapper.updateUser(user);
        if (i>0){
            return Reslut.succeed();
        }
        return Reslut.error("修改失败");
    }
}
