package com.chenxianyu.model.vo;

import com.chenxianyu.model.enity.Course;
import lombok.Data;

@Data
public class CourseVo  {
    private String courseId;
    private String classId;
    private String courseName;
    private String year;
    private String term;
    private String hour;
    private String className;
}
