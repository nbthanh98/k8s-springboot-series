package com.vntechies.k8sspringbootseries.courses.dto;

import lombok.Data;

@Data
public class JoinCourseReq {
    private String courseId;
    private String studentId;
}
