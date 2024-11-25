package com.chenxianyu.controller;

import com.chenxianyu.model.enity.Classes;
import com.chenxianyu.model.enity.Insrtructor;
import com.chenxianyu.model.vo.Reslut;
import com.chenxianyu.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.ClassesKey;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@CrossOrigin
@RestController
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private ClassesService classesService;

    /**
     * 添加班级
     *
     * @param classes
     * @return
     */
    @PostMapping("/addClasses")

    public Reslut addClasses(@RequestBody Classes classes) {
        // 创建一个随机数生成器
        Random random = new Random();
        // 生成一个长整型随机数并将其转换为字符串，作为课程 ID
        long l = random.nextLong();
        classes.setClassId(String.valueOf(l));
        // 调用服务层的方法，添加课程并返回结果
        return classesService.addClasses(classes);
    }
    //1233

    @PostMapping("/getClassByInstId")
    public Reslut getClassByInstId(@RequestBody Insrtructor insrtructor){
        // 调用服务层的方法，根据讲师 ID 查询所教授的课程并返回结果
        return classesService.getClassByInstId(insrtructor);
    }

    @PostMapping("/updateClasses")
    // 调用服务层的方法，根据课程对象更新课程信息并返回结果
    public Reslut updateClasses(@RequestBody Classes classes){
        return classesService.updateClasses(classes);
    }

    @PostMapping("/delectClasses")
    public Reslut delectClasses(@RequestBody Classes classes){
        return classesService.delectClasses(classes);
    }
    // 调用服务层的方法，根据课程对象删除课程信息并返回结果

    @PostMapping("/getAllClasses")
    public Reslut getAllClasses(){
        return classesService.getAllClasses();
    }

    @PostMapping("/updateClassesAdmin")
    public Reslut updateClassesAdmin(@RequestBody Classes classes){
        return classesService.updateClassesAdmin(classes);
    }

    @PostMapping("/getAllClassItem")
    public Reslut getAllClassItem(){
        return classesService.getAllClassItem();
    }
}
