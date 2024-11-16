package com.chenxianyu.mapper;

import com.chenxianyu.model.enity.Leave;
import com.chenxianyu.model.vo.LeaveVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface LeaveMapper {
    @Select("select * from sys_leave where leave_id =#{id}")
    Leave selectLeaveById(String id);

    @Select("select * from sys_leave")
    List<Leave> selectAllLeave();

    @Delete("delete from sys_leave where leave_id+#{id}")
    void delectLeaveById(String id);

    @Select("select * from sys_leave where inst_id =#{instId}")
    List<Leave> selectLeaveByInstId(String instId);

    @Select("select course_name from sys_course where course_id=#{courseId}")
    String selectCourseNameById(String courseId);

    @Update("update sys_leave set status = #{status},opinion = #{opinion} where leave_id = #{leaveId}")
    void updateLeave(LeaveVo leaveVo);
}
