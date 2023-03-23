package com.vntechies.k8sspringbootseries.courses.dto;

import lombok.Data;

import java.util.List;

@Data
public class CourseDetail {
    private CourseDto course;
    private List<MemberInfo> members;
}
