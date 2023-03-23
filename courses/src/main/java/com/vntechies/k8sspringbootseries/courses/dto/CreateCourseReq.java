package com.vntechies.k8sspringbootseries.courses.dto;

import lombok.Data;

@Data
public class CreateCourseReq {
    private String name;
    private String desc;
    private String author;
}
