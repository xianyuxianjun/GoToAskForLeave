package com.chenxianyu.mapper;

import com.chenxianyu.model.enity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from sys_user")
    List<User> selectAllUser();

    @Select("select * from sys_user where userid=#{id}")
    User selectUserById(String id);

    @Insert("insert into sys_user (userid, fullname, password, telephone, emali,role) VALUES (#{userId},#{fullName},#{passord},#{telephpne},#{email},#{role})")
    void addUser(User user);

    @Delete("delete from sys_user where userid=#{id}")
    void delectUserById(String id);
}
