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
    /**
     * 处理 POST 请求，删除指定的课程。
     *
     * @param course 包含要删除的课程信息的 Course 对象。
     * @return 返回一个 Reslut 对象，指示删除操作的结果，包括成功或失败状态及相关信息。
     */
    @PostMapping("/delectCourse")
    // 调用服务层的方法，删除课程并返回结果
    public Reslut delectCourse(@RequestBody Course course){
        return courseService.delectCourse(course);
    }
    /**
     * 处理 POST 请求，更新指定的课程信息。
     *
     * @param course 包含更新后的课程信息的 Course 对象。
     * @return 返回一个 Reslut 对象，指示更新操作的结果，包括成功或失败状态及相关信息。
     */
    @PostMapping("/updateCourse")
    // 调用服务层的方法，更新课程信息并返回结果
    public Reslut updateCourse(@RequestBody Course course){
        return courseService.updateCourse(course);
    }
    /**
     * 处理 POST 请求，获取指定学生报名的课程信息。
     *
     * @param student 包含学生身份信息的 Student 对象，用于查询该学生所报课程。
     * @return 返回一个 Reslut 对象，包含指定学生的课程信息。
     */
    @PostMapping("/getCourse")
    // 调用服务层的方法，获取学生所报的课程并返回结果
    public Reslut getCourse(@RequestBody Student student){
        return courseService.getCourse(student);
    }
    /**
     * 处理 POST 请求，获取所有课程的列表。
     *
     * @return 返回一个 Reslut 对象，包含所有课程的信息和相关状态。
     */
    @PostMapping("/getAllCourse")
    // 调用服务层的方法，获取所有课程信息并返回结果
    public Reslut getAllCourse(){
        return courseService.getAllCourse();
    }
}
