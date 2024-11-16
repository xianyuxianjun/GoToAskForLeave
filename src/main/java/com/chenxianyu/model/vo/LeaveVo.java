package com.chenxianyu.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class LeaveVo {
    //请假记录id
    private String leaveId;
    //请假课程
    private String courseName;
    //请假人id
    private String stuId;
    //请假人姓名
    private String stuName;
    //请假人班级
    private String className;
    //请假事由
    private String reason;
    //请假天数
    private String daynum;
    //请假状态
    private String status;
    //提交时间
    private String audittime;
    //审批意见
    private String opinion;
}