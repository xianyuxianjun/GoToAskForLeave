package com.chenxianyu.mapper;

import com.chenxianyu.model.enity.Leave;
import com.chenxianyu.model.vo.LeaveVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LeaveMapper {
    @Select("select * from sys_leave where inst_id =#{instId}")
    List<Leave> selectLeaveByInstId(String instId);

    @Select("select course_name from sys_course where course_id=#{courseId}")
    String selectCourseNameById(String courseId);
}
