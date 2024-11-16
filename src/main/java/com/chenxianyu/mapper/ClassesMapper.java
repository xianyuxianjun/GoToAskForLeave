package com.chenxianyu.mapper;

import com.chenxianyu.model.enity.Classes;
import com.chenxianyu.model.enity.Insrtructor;
import com.chenxianyu.model.enity.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClassesMapper {
    @Select("select * from sys_classes where inst_id=#{instId}")
    List<Classes> selectClassByInstId(Insrtructor inst);

    @Select("select * from sys_student where class_id=#{classId}")
    List<Student> selectStudentByClassId(String classId);

    @Select("select * from sys_classes where class_id=#{classId}")
    Classes selectClassByClassId(String classId);

    @Insert("insert into sys_classes (class_id, class_name, dep_id, major, grade, inst_id) VALUES (#{classId},#{className},#{depId},#{major},#{grade},#{instId})")
    int addClass(Classes classes);

    @Delete("delete from sys_classes where class_id=#{classId}")
    int delectClass(String classId);
}
