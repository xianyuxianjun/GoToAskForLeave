package com.chenxianyu.service;

import com.chenxianyu.mapper.StudentMapper;
import com.chenxianyu.model.enity.Student;
import com.chenxianyu.model.vo.Reslut;
import com.chenxianyu.utils.MD5Encryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public Reslut delectStudentById(Student student) {
        int i = studentMapper.deleteStudentById(student.getStuId());
        if (i>0){
            return Reslut.succeed();
        }
        return Reslut.error("删除失败");
    }

    public Reslut getStudentByClassId(Student student) {
        List<Student> studentList = studentMapper.selectStudentByClassId(student.getClassId());
        return Reslut.succeed(studentList);
    }

    public Reslut addStudent(Student student) {
        Student student1 = studentMapper.selectStudentByEmail(student.getEmail());
        if (student1 != null){
            return Reslut.error("用户已存在");
        }
        Random random = new Random();
        long l = random.nextLong();
        student.setStuId(String.valueOf(l));
        student.setPassword(MD5Encryptor.encryptToMD5("123456"));
        int i = studentMapper.addStudent(student);
        if (i>0){
            return Reslut.succeed();
        }
        return Reslut.error("添加学生失败");
    }
}
