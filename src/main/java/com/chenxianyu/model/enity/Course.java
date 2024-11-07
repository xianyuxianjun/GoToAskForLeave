package com.chenxianyu.model.enity;

import lombok.Data;

@Data
public class Course {
    private String courseId;
    private String classId;
    private String courseName;
    private String year;
    private String term;
    private String hour;
}
