package com.chenxianyu.model.enity;

import lombok.Data;

import java.util.Date;

@Data
public class Leave {
    private String leaveId;
    private String courseId;
    private String reason;
    private String daynum;
    private String status;
    private Date audittime;
    private Date opinion;

}
