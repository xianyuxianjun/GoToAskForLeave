package com.chenxianyu.controller;

import com.chenxianyu.model.enity.Student;
import com.chenxianyu.model.vo.Reslut;
import com.chenxianyu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin 
@RestController
@RequestMapping("/student")
public class StudebtController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/delectStudent")
    public Reslut delectStudentById(@RequestBody Student student){
        return studentService.delectStudentById(student);
    }

    @PostMapping("/getStudentByClassId")
    public Reslut getStudentByClassId(@RequestBody Student student){
        return studentService.getStudentByClassId(student);
    }
}
