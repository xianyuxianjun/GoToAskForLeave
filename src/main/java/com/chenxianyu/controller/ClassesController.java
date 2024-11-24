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
        Random random = new Random();
        long l = random.nextLong();
        classes.setClassId(String.valueOf(l));
        return classesService.addClasses(classes);
    }

    @PostMapping("/getClassByInstId")
    public Reslut getClassByInstId(@RequestBody Insrtructor insrtructor){
        return classesService.getClassByInstId(insrtructor);
    }

    @PostMapping("/updateClasses")
    public Reslut updateClasses(@RequestBody Classes classes){
        return classesService.updateClasses(classes);
    }

    @PostMapping("/delectClasses")
    public Reslut delectClasses(@RequestBody Classes classes){
        return classesService.delectClasses(classes);
    }

    @PostMapping("/getAllClasses")
    public Reslut getAllClasses(){
        return classesService.getAllClasses();
    }

}
