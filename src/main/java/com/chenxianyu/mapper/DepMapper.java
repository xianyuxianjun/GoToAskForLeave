package com.chenxianyu.mapper;

import com.chenxianyu.model.enity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepMapper {
    @Select("select * from sys_department")
    List<Department> selectAllDep();

    @Select("select * from sys_department where dep_id=#{id}")
    Department selectDepById(String id);
}
