package com.chenxianyu.service;

import com.chenxianyu.mapper.ClassesMapper;
import com.chenxianyu.mapper.CourseMapper;
import com.chenxianyu.mapper.InsrtructorMapper;
import com.chenxianyu.mapper.StudentMapper;
import com.chenxianyu.model.enity.Classes;
import com.chenxianyu.model.enity.Course;
import com.chenxianyu.model.enity.Insrtructor;
import com.chenxianyu.model.enity.Student;
import com.chenxianyu.model.vo.ClassVo;
import com.chenxianyu.model.vo.CourseVo;
import com.chenxianyu.model.vo.MyCourseVo;
import com.chenxianyu.model.vo.Reslut;
import com.chenxianyu.utils.ObjectCopier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private ClassesMapper classesMapper;
    @Autowired
    private InsrtructorMapper insrtructorMapper;
    @Autowired
    private StudentMapper studentMapper;

    public  Reslut addCourse(Course course) {
        Random random = new Random();
        long l = random.nextLong();
        course.setCourseId(String.valueOf(l));
        int i = courseMapper.addCourse(course);
        if (i==1){
            return Reslut.succeed();
        }
        return Reslut.error("添加失败");
    }

    public Reslut getCourseList(Insrtructor insrtructor) throws InvocationTargetException, IllegalAccessException {
        List<Classes> classesList = classesMapper.selectClassByInstId(insrtructor);
        List<Course> courseList = new ArrayList<>();
        for (Classes classes : classesList) {
            List<Course> courseList1 = courseMapper.selectCourseByClassId(classes.getClassId());
            courseList.addAll(courseList1);
        }
        List<CourseVo> courseVos = new ArrayList<>();
        for (Course course : courseList) {
            CourseVo courseVo = new CourseVo();
            ObjectCopier.copyProperties(course,courseVo);
            courseVo.setClassName(classesMapper.selectClassByClassId(course.getClassId()).getClassName());
            courseVos.add(courseVo);
        }
        return Reslut.succeed(courseVos);
    }

    public Reslut delectCourse(Course course) {
        int i = courseMapper.delectCourseById(course.getCourseId());
        if (i == 1){
            return Reslut.succeed();
        }
        return Reslut.error("删除失败");
    }

    public Reslut updateCourse(Course course) {
        int i = courseMapper.updateCourse(course);
        if (i == 1){
            return Reslut.succeed();
        }else{
            return Reslut.error("更新失败");
        }
    }

    public Reslut getCourse(Student student) {
        Student student1 = studentMapper.selectStudentByStuId(student.getStuId());
        List<Course> courseList = courseMapper.selectCourseByClassId(student1.getClassId());
        List<MyCourseVo> myCourseVos = new ArrayList<>();
        for (Course course : courseList) {
            MyCourseVo myCourseVo = new MyCourseVo();
            myCourseVo.setTitle(course.getCourseName());
            myCourseVo.setValue(course.getCourseId());
            myCourseVos.add(myCourseVo);
        }
        return Reslut.succeed(myCourseVos);
    }
}
