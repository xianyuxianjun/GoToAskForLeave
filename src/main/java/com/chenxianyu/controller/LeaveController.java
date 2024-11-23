package com.chenxianyu.controller;

import com.chenxianyu.mapper.LeaveMapper;
import com.chenxianyu.model.enity.Leave;
import com.chenxianyu.model.enity.Student;
import com.chenxianyu.model.vo.LeaveVo;
import com.chenxianyu.model.vo.Reslut;
import com.chenxianyu.service.LeaveService;
import com.chenxianyu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/leave")
public class LeaveController {
    @Autowired
    private LeaveService leaveService;

    /**
     * 辅导员审批之后，更新请假信息
     *
     * @param leaveVo
     * @return
     */
    @PostMapping("/updateLeave")
    public Reslut updateLeave(@RequestBody LeaveVo leaveVo){
        return leaveService.updateLeave(leaveVo);
    }

    @PostMapping("/delectLeave")
    public Reslut delectLeave(@RequestBody Leave leave){
        return leaveService.delectLeave(leave);
    }

    @PostMapping("/getLeaveByStuId")
    public Reslut getLeaveByStuId(@RequestBody Student student){
        return leaveService.getLeaveByStuId(student);
    }

    @PostMapping("/addLeave")
    public Reslut addLeave(@RequestBody Leave leave){
        return leaveService.addLeave(leave);
    }
}
