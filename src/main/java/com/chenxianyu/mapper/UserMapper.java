package com.chenxianyu.mapper;

import com.chenxianyu.model.enity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from sys_user")
    List<User> selectAllUser();

    @Select("select * from sys_user where userid=#{id}")
    User selectUserById(String id);

    @Insert("insert into sys_user (userid, fullname, password, telephone, email,role) VALUES (#{userId},#{fullname},#{password},#{telephone},#{email},#{role})")
    int addUser(User user);

    @Delete("delete from sys_user where userid=#{id}")
    int delectUserById(String id);

    @Select("select * from sys_user where email=#{username}")
    User selectUserByEmail(String username);

    @Update("update sys_user set fullname=#{fullname},telephone=#{telephone},email=#{email} where userid =#{userId}")
    int updateUser(User user);
}
