package com.chenxianyu.model.enity;

import lombok.Data;

import java.sql.Date;

@Data
public class Leave {
    //请假记录id
    private String leaveId;
    //请假课程id
    private String courseId;
    //请假人id
    private String stuId;
    //辅导员Id
    private String instId;
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
