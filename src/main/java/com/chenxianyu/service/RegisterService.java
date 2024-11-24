package com.chenxianyu.service;

import com.chenxianyu.mapper.InsrtructorMapper;
import com.chenxianyu.mapper.StudentMapper;
import com.chenxianyu.mapper.UserMapper;
import com.chenxianyu.model.dto.RegisterDto;
import com.chenxianyu.model.enity.Insrtructor;
import com.chenxianyu.model.enity.Student;
import com.chenxianyu.model.enity.User;
import com.chenxianyu.model.vo.Reslut;
import com.chenxianyu.utils.MD5Encryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RegisterService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private InsrtructorMapper insrtructorMapper;
    @Autowired
    private UserMapper userMapper;

    public Reslut segister(RegisterDto registerDto) {
        if (registerDto.getPassword()==null||registerDto.getRole()==null||registerDto.getUsername()==null||registerDto.getSex()==null){
            return Reslut.error("注册失败");
        }
        if (registerDto.getRole().equals("学生")){
            return studentRegister(registerDto);
        }
        if (registerDto.getRole().equals("辅导员")){
            return instRegister(registerDto);
        }
        if (registerDto.getRole().equals("管理员")){
            return userRegister(registerDto);
        }
        return Reslut.error("注册失败");
    }

    public Reslut studentRegister(RegisterDto registerDto){
        Random random = new Random();
        long l = random.nextLong();
        Student student = new Student();
        student.setStuId(String.valueOf(l));
        student.setEmail(registerDto.getUsername());
        student.setPassword(MD5Encryptor.encryptToMD5(registerDto.getPassword()));
        student.setRole(registerDto.getRole());
        student.setSex(registerDto.getSex());
        student.setStuName(registerDto.getFullName());
        int i = studentMapper.insterStudent(student);
        if (i == 1){
            return Reslut.succeed();
        }
        return Reslut.error("注册失败");
    }

    public Reslut instRegister(RegisterDto registerDto){
        Random random = new Random();
        long l = random.nextLong();
        Insrtructor insrtructor = new Insrtructor();
        insrtructor.setInstId(String.valueOf(l));
        insrtructor.setInstName(registerDto.getFullName());
        insrtructor.setPassword(MD5Encryptor.encryptToMD5(registerDto.getPassword()));
        insrtructor.setRole(registerDto.getRole());
        insrtructor.setEmail(registerDto.getUsername());
        int i = insrtructorMapper.addInst(insrtructor);
        if (i == 1){
            return Reslut.succeed();
        }
        return Reslut.error("注册失败");
    }

    public Reslut userRegister(RegisterDto registerDto){
        Random random = new Random();
        long l = random.nextLong();
        User user = new User();
        user.setFullname(registerDto.getFullName());
        user.setUserId(String.valueOf(l));
        user.setRole(registerDto.getRole());
        user.setPassword(MD5Encryptor.encryptToMD5(registerDto.getPassword()));
        user.setEmail(registerDto.getUsername());
        int i = userMapper.addUser(user);
        if (i == 1){
            return Reslut.succeed();
        }
        return Reslut.error("注册失败");
    }

}
