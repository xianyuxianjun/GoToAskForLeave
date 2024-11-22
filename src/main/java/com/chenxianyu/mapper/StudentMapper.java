package com.chenxianyu.mapper;

import com.chenxianyu.model.dto.LoginDto;
import com.chenxianyu.model.enity.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select * from sys_student")
    List<Student> selectAllStudent();

    @Delete("delete from sys_student where stu_id=#{id}")
    int deleteStudentById(String id);

    @Insert("insert into sys_student (stu_id, class_id, stu_name, sex, address, stu_tel, contact, contact_tel, password, role, email) VALUES (#{stuId},#{classId},#{stuName},#{sex},#{address},#{stuTel},#{contact},#{contactTel},#{password},#{role},#{email})")
    void addStudent(Student student);

    @Select("select * from sys_student where stu_id=#{Id}")
    Student selectStudentByStuId(String Id);

    @Select("select stu_name from sys_student where stu_id=#{stuId}")
    String selectStuNameById(String stuId);

    @Select("select class_name from sys_classes where class_id=#{classId}")
    String selectClassNamebyClassId(String classId);

    @Select("select * from sys_student where class_id=#{classId}")
    List<Student> selectStudentByClassId(String classId);

    @Select("select * from sys_student where email = #{username}")
    Student selectStudentByEmail(LoginDto loginDto);

    @Insert("insert into sys_student (stu_id,sex,password, role, email,stu_name) values (#{stuId},#{sex},#{password},#{role},#{email},#{stuName})")
    int insterStudent(Student student);
}
