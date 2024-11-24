package com.chenxianyu.mapper;

import com.chenxianyu.model.dto.LoginDto;
import com.chenxianyu.model.enity.Insrtructor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InsrtructorMapper {
    @Select("select * from sys_instructor where inst_id=#{userId}")
    Insrtructor selectInstByInstId(String userId);

    @Delete("delete from sys_instructor where inst_id=#{id}")
    int delectInstByid(String id);

    @Select("select * from sys_instructor")
    List<Insrtructor> selectAllInst();

    @Insert("insert into sys_instructor (inst_id, inst_name, dep_id,telephone,role,email,password) VALUES (#{instId},#{instName},#{depId},#{telephone},#{role},#{email},#{password})")
    int addInst(Insrtructor insrtructor);

    @Select("select * from sys_instructor where email = #{username}")
    Insrtructor selectInstByEamil(String username);

    @Update("update sys_instructor set inst_name=#{instName}, dep_id=#{depId},telephone=#{telephone},email=#{email} where inst_id=#{instId} ")
    int updateInst(Insrtructor insrtructor);
}
