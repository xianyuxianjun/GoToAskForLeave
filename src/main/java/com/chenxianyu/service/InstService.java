package com.chenxianyu.service;

import com.chenxianyu.mapper.ClassesMapper;
import com.chenxianyu.model.enity.Classes;
import com.chenxianyu.model.enity.Insrtructor;
import com.chenxianyu.model.enity.Student;
import com.chenxianyu.model.vo.Reslut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstService {
    @Autowired
    private ClassesMapper classesMapper;

    /**
     * 查询辅导员的全部学生
     * @param inst
     * @return
     */
    public Reslut selectAllStudentByInstId(Insrtructor inst){
        List<Classes> classesList = classesMapper.selectClassByInstId(inst);
        List<String> classIdList = new ArrayList<>();
        for (Classes classes : classesList) {
            classIdList.add(classes.getClassId());
        }
        List<Student> studentList = new ArrayList<>();
        for (String classId : classIdList) {
            studentList.add(classesMapper.selectStudentByClassId(classId));
        }
        System.out.println("asdasdasdasdsad");
        System.out.println(studentList);
        return Reslut.succeed(studentList);
    }
}
