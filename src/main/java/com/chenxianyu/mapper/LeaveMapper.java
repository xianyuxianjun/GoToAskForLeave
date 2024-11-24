package com.chenxianyu.mapper;

import com.chenxianyu.model.enity.Leave;
import com.chenxianyu.model.vo.LeaveVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LeaveMapper {
    @Select("select * from sys_leave where leave_id =#{id}")
    Leave selectLeaveById(String id);

    @Select("select * from sys_leave")
    List<Leave> selectAllLeave();

    @Delete("delete from sys_leave where leave_id = #{id}")
    int delectLeaveById(String id);

    @Select("select * from sys_leave where inst_id =#{instId}")
    List<Leave> selectLeaveByInstId(String instId);

    @Select("select course_name from sys_course where course_id=#{courseId}")
    String selectCourseNameById(String courseId);

    @Update("update sys_leave set status = #{status},opinion = #{opinion} where leave_id = #{leaveId}")
    void updateLeave(LeaveVo leaveVo);

    @Select("select * from sys_leave where stu_id=#{stuId}")
    List<Leave> selectLeaveByStuId(String stuId);

    @Insert("insert into sys_leave (leave_id, course_id, reason, daynum, status, audittime, opinion, stu_id, inst_id) VALUES (#{leaveId},#{courseId},#{reason},#{daynum},#{status},#{audittime},#{opinion},#{stuId},#{instId})")
    int addLeave(Leave leave);
}
