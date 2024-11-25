package com.chenxianyu.mapper;

import com.chenxianyu.model.enity.Department;
import lombok.Data;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepMapper {
    @Select("select * from sys_department")
    List<Department> selectAllDep();

    @Select("select * from sys_department where dep_id=#{id}")
    Department selectDepById(String id);

    @Delete("delete from sys_department where dep_id=#{depId}")
    int delectDepById(String depId);

    @Insert("insert into sys_department (dep_id, dep_name) VALUES (#{depId},#{depName})")
    int addDep(Department department);

    @Update("update sys_department set dep_id=#{depId},dep_name=#{depName} where dep_id=#{oldId}")
    int updateDep(Department department);
}
