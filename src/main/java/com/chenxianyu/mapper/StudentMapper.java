package com.chenxianyu.mapper;

import com.chenxianyu.model.enity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public interface StudentMapper {
    @Select("select * from sys_student where stu_id=#{userId}")
    Student selectStudentByStuId(String userId);
}
