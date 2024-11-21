package com.chenxianyu.service;

import com.chenxianyu.mapper.InsrtructorMapper;
import com.chenxianyu.mapper.StudentMapper;
import com.chenxianyu.mapper.UserMapper;
import com.chenxianyu.model.dto.LoginDto;
import com.chenxianyu.model.enity.Insrtructor;
import com.chenxianyu.model.enity.Student;
import com.chenxianyu.model.enity.User;
import com.chenxianyu.model.vo.Reslut;
import com.chenxianyu.model.vo.UserVo;
import com.chenxianyu.utils.MD5Encryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private InsrtructorMapper insrtructorMapper;
    @Autowired
    private UserMapper userMapper;
    /**
     * 登录
     * @param loginDto
     * @return
     */
    public Reslut login(LoginDto loginDto) {
        if (loginDto.getUsername()==null&&loginDto.getUsername()==null&&loginDto.getPassword()==null){
            return Reslut.error("登陆失败");
        }
        UserVo userVo = new UserVo();
        if (loginDto.getRole().equals("学生")){
            Student student = studentMapper.selectStudentByEmail(loginDto);
            if (student == null){
                return Reslut.error("用户不存在");
            }
            if (student.getPassword().equals(MD5Encryptor.encryptToMD5(loginDto.getPassword()))){
                userVo.setRole(student.getRole());
                userVo.setUserId(student.getStuId());
                return Reslut.succeed(userVo);
            }
             return Reslut.error("密码错误");
        }
        if (loginDto.getRole().equals("辅导员")){
            Insrtructor insrtructor = insrtructorMapper.selectInstByEamil(loginDto);
            if (insrtructor == null){
                return Reslut.error("用户不存在");
            }
            if (insrtructor.getPassword().equals(MD5Encryptor.encryptToMD5(loginDto.getPassword()))){
                userVo.setUserId(insrtructor.getInstId());
                userVo.setRole(insrtructor.getRole());
                return Reslut.succeed(userVo);
            }
            return Reslut.error("密码错误");
        }
        if (loginDto.getRole().equals("管理员")){
            User user = userMapper.selectUserByEmail(loginDto);
            if (user == null){
                return Reslut.error("用户不存在");
            }
            if (user.getPassword().equals(MD5Encryptor.encryptToMD5(loginDto.getPassword()))){
                userVo.setUserId(user.getUserId());
                userVo.setRole(user.getRole());
                return Reslut.succeed();
            }
            return Reslut.error("密码错误");
        }
        return Reslut.error("登陆失败");
    }
}
