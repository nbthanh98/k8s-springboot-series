package com.vntechies.k8sspringbootseries.courses.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CoursesDto {
    private UUID id;
    private String name;
    private String desc;
    private String author;
}
