package com.chenxianyu.mapper;

import com.chenxianyu.model.enity.Classes;
import com.chenxianyu.model.enity.Insrtructor;
import com.chenxianyu.model.enity.Student;
import org.apache.ibatis.annotations.*;

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

    @Update("update sys_classes set class_name=#{className}, dep_id=#{depId}, major=#{major}, grade=#{grade} where class_id=#{classId}")
    int updateClasses(Classes classes);

    @Select("select * from sys_classes")
    List<Classes> selectAllClasses();

    @Update("update sys_classes set class_name=#{className}, dep_id=#{depId}, major=#{major}, grade=#{grade},inst_id=#{instId} where class_id=#{classId}")
    int updateClassesAdmin(Classes classes);
}
