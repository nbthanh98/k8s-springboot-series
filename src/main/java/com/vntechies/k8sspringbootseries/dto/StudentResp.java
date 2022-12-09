package com.vntechies.k8sspringbootseries.dto;

import com.vntechies.k8sspringbootseries.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResp {
    private UUID id;
    private String fullName;
    private String dateOfBirth;
    private String hometown;
    private Gender gender;
}
