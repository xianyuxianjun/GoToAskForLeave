package com.chenxianyu.service;

import com.chenxianyu.mapper.InsrtructorMapper;
import com.chenxianyu.mapper.StudentMapper;
import com.chenxianyu.model.dto.LoginDto;
import com.chenxianyu.model.enity.Insrtructor;
import com.chenxianyu.model.enity.Student;
import com.chenxianyu.model.vo.Reslut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private InsrtructorMapper insrtructorMapper;
    /**
     * 登录
     * @param loginDto
     * @return
     */
    public Reslut login(LoginDto loginDto) {
        if (loginDto.getRole().equals("student")){
            Student student = studentMapper.selectStudentByStuId(loginDto.getUserId());
            if (student == null){
                return Reslut.error("用户不存在");
            }
            if (!student.getPassword().equals(loginDto.getPassword())){
                return Reslut.error("密码错误");
            }
            return Reslut.succeed();
        }
        if (loginDto.getRole().equals("inst")){
            Insrtructor insrtructor = insrtructorMapper.selectInstByInstId(loginDto.getUserId());
            if(insrtructor == null){
                return Reslut.error("用户不存在");
            }
            if (!insrtructor.getPassword().equals(loginDto.getPassword())){
                return Reslut.error("密码错误");
            }
            return Reslut.succeed();
        }
        return Reslut.error("您无权限登录");
    }
}
