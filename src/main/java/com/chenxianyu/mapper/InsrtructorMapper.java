package com.chenxianyu.mapper;

import com.chenxianyu.model.enity.Insrtructor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface InsrtructorMapper {
    @Select("select * from sys_instructor where inst_id=#{userId}")
    Insrtructor selectInstByInstId(String userId);
}
