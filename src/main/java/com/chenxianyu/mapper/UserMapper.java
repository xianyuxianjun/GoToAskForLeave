package com.chenxianyu.mapper;

import com.chenxianyu.model.dto.LoginDto;
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

    @Insert("insert into sys_user (userid, fullname, password, telephone, emali,role) VALUES (#{userId},#{fullname},#{password},#{telephone},#{email},#{role})")
    int addUser(User user);

    @Delete("delete from sys_user where userid=#{id}")
    void delectUserById(String id);

    @Select("select * from sys_user where emali=#{username}")
    User selectUserByEmail(LoginDto loginDto);
}
