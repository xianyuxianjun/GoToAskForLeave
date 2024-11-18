package com.chenxianyu.mapper;

import com.chenxianyu.model.enity.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper {
    @Select("select * from sys_course where course_name=#{name}")
    Course selectCourseByCourseName(String name);

    @Select("select * from sys_course where course_id=#{id}")
    Course selectCourseById(String id);

    @Select("select * from sys_course")
    List<Course> selectAllCourse();

    @Delete("delete from sys_course where course_id=#{id}")
    int delectCourseById(String id);

    @Insert("insert into sys_course (course_id, class_id, course_name, year, term, hour) VALUES (#{courseId},#{classId},#{courseName},#{year},#{term},#{hour})")
    int addCourse(Course course);

    @Select("select * from sys_course where class_id =#{classId}")
    List<Course> selectCourseByClassId(String classId);
}
