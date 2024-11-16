package com.chenxianyu.service;

import com.chenxianyu.mapper.CourseMapper;
import com.chenxianyu.mapper.LeaveMapper;
import com.chenxianyu.mapper.StudentMapper;
import com.chenxianyu.model.enity.Leave;
import com.chenxianyu.model.vo.LeaveVo;
import com.chenxianyu.model.vo.Reslut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveService {
    @Autowired
    private LeaveMapper leaveMapper;
    private CourseMapper courseMapper;
    private StudentMapper studentMapper;

    public Reslut updateLeave(LeaveVo leaveVo) {
        leaveMapper.updateLeave(leaveVo);
        return Reslut.succeed();
    }


    public Leave convertToLeave(LeaveVo leaveVo){
        Leave leave = new Leave();
        leave.setLeaveId(leaveVo.getLeaveId());
        leave.setOpinion(leaveVo.getOpinion());
        leave.setDaynum(leaveVo.getDaynum());
        leave.setReason(leaveVo.getReason());
        leave.setAudittime(leaveVo.getAudittime());
        leave.setStatus(leaveVo.getStatus());
        leave.setStuId(leaveVo.getStuId());
        leave.setCourseId(courseMapper.selectCourseByCourseName(leaveVo.getCourseName()).getCourseId());
        leave.setInstId(studentMapper.selectStudentByStuId(leaveVo.getStuId()).getInstId());
        return leave;
    }
}
