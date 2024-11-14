package com.chenxianyu.service;

import com.chenxianyu.mapper.ClassesMapper;
import com.chenxianyu.mapper.LeaveMapper;
import com.chenxianyu.mapper.StudentMapper;
import com.chenxianyu.model.enity.Classes;
import com.chenxianyu.model.enity.Insrtructor;
import com.chenxianyu.model.enity.Leave;
import com.chenxianyu.model.enity.Student;
import com.chenxianyu.model.vo.LeaveVo;
import com.chenxianyu.model.vo.Reslut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstService {
    @Autowired
    private ClassesMapper classesMapper;
    @Autowired
    private LeaveMapper leaveMapper;
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 查询辅导员的全部学生
     * @param inst
     * @return
     */
    public Reslut selectAllStudentByInstId(Insrtructor inst){
        List<Classes> classesList = classesMapper.selectClassByInstId(inst);
        List<String> classIdList = new ArrayList<>();
        for (Classes classes : classesList) {
            classIdList.add(classes.getClassId());
        }
        List<Student> studentList = new ArrayList<>();
        for (String classId : classIdList) {
            studentList.add(classesMapper.selectStudentByClassId(classId));
        }
        System.out.println(studentList);
        return Reslut.succeed(studentList);
    }

    public Reslut getLeaveList(Insrtructor inst) {
        List<Leave> leaves = leaveMapper.selectLeaveByInstId(inst.getInstId());
        List<LeaveVo> leaveVos = new ArrayList<>();
        for (Leave leaf : leaves) {
            LeaveVo leaveVo = convertToLeaveVo(leaf);
            leaveVo.setCourseName(leaveMapper.selectCourseNameById(leaf.getCourseId()));
            leaveVo.setStuName(studentMapper.selectStuNameById(leaf.getStuId()));
            Student student = studentMapper.selectStudentByStuId(leaf.getStuId());
            String className = studentMapper.selectClassNamebyClassId(student.getClassId());
            leaveVo.setClassName(className);
            leaveVos.add(leaveVo);
        }
        return Reslut.succeed(leaveVos);
    }

    /**
     * 转换对象
     * @param leave
     * @return
     */
    private LeaveVo convertToLeaveVo(Leave leave){
        LeaveVo leaveVo = new LeaveVo();
        leaveVo.setLeaveId(leave.getLeaveId());
        leaveVo.setAudittime(leave.getAudittime());
        leaveVo.setReason(leave.getReason());
        leaveVo.setDaynum(leave.getDaynum());
        leaveVo.setStuId(leave.getStuId());
        leaveVo.setStatus(leave.getStatus());
        return leaveVo;
    }
}
