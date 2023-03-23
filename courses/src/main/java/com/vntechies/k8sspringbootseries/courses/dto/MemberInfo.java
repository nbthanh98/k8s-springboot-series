package com.vntechies.k8sspringbootseries.courses.dto;

import lombok.Data;

@Data
public class MemberInfo {
    private Long id;
    private String fullName;
    private String dateOfBirth;
    private String hometown;
    private String gender;
}
