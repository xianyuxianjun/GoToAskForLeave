package com.chenxianyu.controller;

import com.chenxianyu.mapper.InsrtructorMapper;
import com.chenxianyu.model.enity.Insrtructor;
import com.chenxianyu.model.vo.Reslut;
import com.chenxianyu.service.InstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inst")
public class InstController {
    @Autowired
    private InstService instService;

    /**
     * 根据辅导员的id查询属于他的学生
     * @param inst
     * @return
     */
    public Reslut getAllStudentByInstId(@RequestBody Insrtructor inst){
        return instService.selectAllStudentByInstId(inst);
    }
}
