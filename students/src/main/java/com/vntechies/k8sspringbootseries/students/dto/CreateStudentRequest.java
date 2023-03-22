package com.vntechies.k8sspringbootseries.students.dto;

import com.vntechies.k8sspringbootseries.students.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentRequest {
    private String fullName;
    private String dateOfBirth;
    private String hometown;
    private Gender gender;
}