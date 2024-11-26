package com.chenxianyu.controller;

import com.chenxianyu.model.enity.Course;
import com.chenxianyu.model.enity.Insrtructor;
import com.chenxianyu.model.enity.Student;
import com.chenxianyu.model.vo.Reslut;
import com.chenxianyu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@CrossOrigin
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/addCourse")
    // 调用服务层的方法，添加新课程并返回结果
    public Reslut addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @PostMapping("/getCourseList")
    public Reslut getCourseList(@RequestBody Insrtructor insrtructor) throws InvocationTargetException, IllegalAccessException {
    // 调用服务层的方法，获取课程列表，并返回结果
        return courseService.getCourseList(insrtructor);
    }

    @PostMapping("/delectCourse")
    public Reslut delectCourse(@RequestBody Course course){
        return courseService.delectCourse(course);
    }

    @PostMapping("/updateCourse")
    public Reslut updateCourse(@RequestBody Course course){
        return courseService.updateCourse(course);
    }

    @PostMapping("/getCourse")
    public Reslut getCourse(@RequestBody Student student){
        return courseService.getCourse(student);
    }

    @PostMapping("/getAllCourse")
    public Reslut getAllCourse(){
        return courseService.getAllCourse();
    }
}
