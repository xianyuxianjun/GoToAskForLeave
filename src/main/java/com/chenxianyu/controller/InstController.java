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
     * 辅导员查询所管理的学生信息
     * @param inst
     * @return
     */
    @PostMapping("getClassStudent")
    public Reslut getAllStudentByInstId(@RequestBody Insrtructor inst){
        return instService.selectAllStudentByInstId(inst);
    }

    /**
     * 辅导员查询所管理的请假信息
     * @param insrtructor
     * @return
     */
    @PostMapping("/getLeaveList")
    public Reslut getLeaveList(@RequestBody Insrtructor insrtructor){
        return instService.getLeaveList(insrtructor);
    }

    @PostMapping("/classList")
    public Reslut getClassList(@RequestBody Insrtructor insrtructor){
        return instService.getClassList(insrtructor);
    }

    @PostMapping("/getAllInst")
    public Reslut getAllInst(){
        return instService.getAllInst();
    }

    @PostMapping("/delectInst")
    public Reslut delectInst(@RequestBody Insrtructor insrtructor){
        return instService.delecyInst(insrtructor);
    }

    @PostMapping("/addInst")
    public Reslut addInst(@RequestBody Insrtructor insrtructor){
        return instService.addInst(insrtructor);
    }

    @PostMapping("/updateInst")
    public Reslut updateInst(@RequestBody Insrtructor insrtructor){
        return instService.updateInst(insrtructor);
    }

    @PostMapping("/getInstItem")
    public Reslut getInstItem(){
        return instService.getInstItem();
    }
}
