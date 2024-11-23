package com.chenxianyu.service;

import com.chenxianyu.mapper.ClassesMapper;
import com.chenxianyu.mapper.CourseMapper;
import com.chenxianyu.mapper.LeaveMapper;
import com.chenxianyu.mapper.StudentMapper;
import com.chenxianyu.model.enity.Classes;
import com.chenxianyu.model.enity.Course;
import com.chenxianyu.model.enity.Leave;
import com.chenxianyu.model.enity.Student;
import com.chenxianyu.model.vo.LeaveVo;
import com.chenxianyu.model.vo.Reslut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class LeaveService {
    @Autowired
    private LeaveMapper leaveMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClassesMapper classesMapper;

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

    public Reslut delectLeave(Leave leave) {
        int i = leaveMapper.delectLeaveById(leave.getLeaveId());
        if (i>0){
            return Reslut.succeed();
        }
        return Reslut.error("删除失败");
    }

    public Reslut getLeaveByStuId(Student student) {
        List<Leave> leaves = leaveMapper.selectLeaveByStuId(student.getStuId());
        return Reslut.succeed(leaves);
    }

    public Reslut addLeave(Leave leave) {
        Random random = new Random();
        long l = random.nextLong();
        leave.setLeaveId(String.valueOf(l));
        Student student = studentMapper.selectStudentByStuId(leave.getStuId());
        Classes classes = classesMapper.selectClassByClassId(student.getClassId());
        leave.setInstId(classes.getInstId());
        leave.setStatus("未审核");
        leave.setOpinion("无");
        int i = leaveMapper.addLeave(leave);
        if (i>0){
            return Reslut.succeed();
        }
        return Reslut.error("提交失败");
    }
}
