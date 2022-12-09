package com.vntechies.k8sspringbootseries.entity;

import com.vntechies.k8sspringbootseries.dto.CreateStudentRequest;
import com.vntechies.k8sspringbootseries.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private UUID id;
    private String fullName;
    private String dateOfBirth;
    private String hometown;
    private Gender gender;

    public static Student createFrom(CreateStudentRequest request) {
        Student student = new Student();
        student.setId(UUID.randomUUID());
        student.setFullName(request.getFullName());
        student.setDateOfBirth(request.getDateOfBirth());
        student.setHometown(request.getHometown());
        student.setGender(request.getGender());
        return student;
    }
}
