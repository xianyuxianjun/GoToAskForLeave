package com.chenxianyu.service;

import com.chenxianyu.mapper.StudentMapper;
import com.chenxianyu.model.enity.Student;
import com.chenxianyu.model.vo.Reslut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
