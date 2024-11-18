package com.chenxianyu.controller;

import com.chenxianyu.model.enity.Course;
import com.chenxianyu.model.enity.Insrtructor;
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
    public Reslut addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @PostMapping("/getCourseList")
    public Reslut getCourseList(@RequestBody Insrtructor insrtructor) throws InvocationTargetException, IllegalAccessException {
        return courseService.getCourseList(insrtructor);
    }

    @PostMapping("/delectCourse")
    public Reslut delectCourse(@RequestBody Course course){
        return courseService.delectCourse(course);
    }
}
