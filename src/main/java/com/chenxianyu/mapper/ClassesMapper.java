package com.chenxianyu.mapper;

import com.chenxianyu.model.enity.Classes;
import com.chenxianyu.model.enity.Insrtructor;
import com.chenxianyu.model.enity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClassesMapper {
    @Select("select * from sys_classes where inst_id=#{instId}")
    List<Classes> selectClassByInstId(Insrtructor inst);

    @Select("select * from sys_student where class_id=#{classId}")
    Student selectStudentByClassId(String classId);
}
