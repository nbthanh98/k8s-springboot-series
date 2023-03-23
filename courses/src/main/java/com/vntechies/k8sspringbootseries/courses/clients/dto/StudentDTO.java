package com.vntechies.k8sspringbootseries.courses.clients.dto;

import lombok.Data;

@Data
public class StudentDTO {
    private Long id;
    private String fullName;
    private String dateOfBirth;
    private String hometown;
    private String gender;
}
