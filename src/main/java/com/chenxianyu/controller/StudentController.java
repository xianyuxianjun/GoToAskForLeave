package com.chenxianyu.controller;

import com.chenxianyu.model.enity.Student;
import com.chenxianyu.model.vo.Reslut;
import com.chenxianyu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// 允许跨域请求
@CrossOrigin
@RestController // 声明该类为 RESTful 控制器
@RequestMapping("/student") // 定义控制器的基础 URL 路径为"/student"
public class StudentController {

    @Autowired
    private StudentService studentService; // 注入学生服务类，用于处理学生相关的业务逻辑

    /**
     * 处理 POST 请求，根据提供的学生信息删除指定学生。
     *
     * @param student 包含要删除的学生信息的 Student 对象
     * @return 返回一个 Reslut 对象，指示删除操作的结果，包括成功或失败状态及相关信息。
     */
    @PostMapping("/delectStudent") // 映射 POST 请求到 "/student/delectStudent" 路径
    public Reslut delectStudentById(@RequestBody Student student) {
        // 调用服务层的方法，根据学生信息进行删除，并返回结果
        return studentService.delectStudentById(student);
    }

    /**
     * 处理 POST 请求，根据班级 ID 获取学生信息。
     *
     * @param student 包含班级 ID 的 Student 对象
     * @return 返回一个 Reslut 对象，包含指定班级的所有学生信息和相关状态。
     */
    @PostMapping("/getStudentByClassId") // 映射 POST 请求到 "/student/getStudentByClassId" 路径
    public Reslut getStudentByClassId(@RequestBody Student student) {
        // 调用服务层的方法，根据班级 ID 获取学生信息并返回结果
        return studentService.getStudentByClassId(student);
    }

    /**
     * 处理 POST 请求，以添加新学生。
     *
     * @param student 包含新学生信息的 Student 对象
     * @return 返回一个 Reslut 对象，指示添加操作的结果，包括成功或失败状态及相关信息。
     */
    @PostMapping("/addStudent") // 映射 POST 请求到 "/student/addStudent" 路径
    public Reslut addStudent(@RequestBody Student student) {
        // 调用服务层的方法，添加新学生并返回结果
        return studentService.addStudent(student);
    }
}
