package com.chenxianyu.controller;
import com.chenxianyu.model.enity.Insrtructor;
import com.chenxianyu.model.vo.Reslut;
import com.chenxianyu.service.InstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
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
    @PostMapping("getClassStudent")
    public Reslut getAllStudentByInstId(@RequestBody Insrtructor inst){
        return instService.selectAllStudentByInstId(inst);
    }
}
