package com.chenxianyu.service;

import com.chenxianyu.mapper.ClassesMapper;
import com.chenxianyu.model.enity.Classes;
import com.chenxianyu.model.vo.Reslut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassesService {
    @Autowired
    private ClassesMapper classesMapper;
    public Reslut addClasses(Classes classes) {
        int i = classesMapper.addClass(classes);
        if (i == 0){
            return Reslut.error("添加失败");
        }
        return Reslut.succeed();
    }
}
