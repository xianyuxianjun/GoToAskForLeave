package com.chenxianyu.service;
import com.chenxianyu.mapper.ClassesMapper;
import com.chenxianyu.mapper.DepMapper;
import com.chenxianyu.mapper.StudentMapper;
import com.chenxianyu.model.enity.Classes;
import com.chenxianyu.model.enity.Insrtructor;
import com.chenxianyu.model.enity.Student;
import com.chenxianyu.model.vo.ClassesVo;
import com.chenxianyu.model.vo.Reslut;
import com.chenxianyu.utils.ObjectCopier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClassesService {
    @Autowired
    private ClassesMapper classesMapper;
    @Autowired
    private DepMapper depMapper;
    @Autowired
    private StudentMapper studentMapper;
    public Reslut addClasses(Classes classes) {
        int i = classesMapper.addClass(classes);
        if (i == 0){
            return Reslut.error("添加失败");
        }
        return Reslut.succeed();
    }

    public Reslut getClassByInstId(Insrtructor insrtructor) {
        List<Classes> classesList = classesMapper.selectClassByInstId(insrtructor);
        List<ClassesVo> classesVos = new ArrayList<>();
        List<Student> studentList = new ArrayList<>();
        int i = 0;
        for (Classes classes : classesList) {
            List<Student> students = studentMapper.selectStudentByClassId(classes.getClassId());
            ClassesVo vo = new ClassesVo();
            i = i+students.size();
            try {
                ObjectCopier.copyProperties(classes,vo);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            vo.setNum(String.valueOf(i));
            vo.setDepName(depMapper.selectDepById(classes.getDepId()).getDepName());
            classesVos.add(vo);
        }
        return Reslut.succeed(classesVos);
    }

    public Reslut updateClasses(Classes classes) {
        int o = classesMapper.updateClasses(classes);
        if (o == 1){
            return Reslut.succeed();
        }
        return Reslut.error("修改失败");
    }

    public Reslut delectClasses(Classes classes) {
        int i = classesMapper.delectClass(classes.getClassId());
        if (i == 1){
            return Reslut.succeed();
        }
        return Reslut.error("删除失败");
    }
}
