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
import com.chenxianyu.model.vo.StudentVo;
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
        //查询辅导员管理的班级
        List<Classes> classesList = classesMapper.selectClassByInstId(inst);
        List<String> classIdList = new ArrayList<>();
        //提取班级Id
        for (Classes classes : classesList) {
            classIdList.add(classes.getClassId());
        }
        List<Student> studentList = new ArrayList<>();
        List<StudentVo> studentVoList = new ArrayList<>();
        //查询班级学生
        for (String classId : classIdList) {
            studentList.addAll(classesMapper.selectStudentByClassId(classId));
        }
        for (Student student : studentList) {
            StudentVo studentVo = convertToStudentVo(student);
            studentVo.setClassName(classesMapper.selectClassByClassId(studentVo.getClassId()).getClassName());
            studentVoList.add(studentVo);
        }
        return Reslut.succeed(studentVoList);
    }

    /**
     * 查询辅导员应当处理的请假条
     * @param inst
     * @return
     */
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
     * leave转换为leaveVo
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

    /**
     * student转换为studentVo
     * @param student
     * @return
     */
    private StudentVo convertToStudentVo(Student student){
        StudentVo studentVo = new StudentVo();
        studentVo.setAddress(student.getAddress());
        studentVo.setContact(student.getContact());
        studentVo.setEmail(student.getEmail());
        studentVo.setInstId(student.getInstId());
        studentVo.setClassId(student.getClassId());
        studentVo.setRole(student.getRole());
        studentVo.setSex(student.getSex());
        studentVo.setPassword(student.getPassword());
        studentVo.setContactTel(student.getContactTel());
        studentVo.setStuTel(student.getStuTel());
        studentVo.setStuName(student.getStuName());
        studentVo.setContact(student.getContact());
        studentVo.setStuId(student.getStuId());
        return studentVo;
    }
}
