package com.vntechies.k8sspringbootseries.courses.dto;

import lombok.Data;

@Data
public class JoinCourseReq {
    private Long courseId;
    private String studentId;
}
