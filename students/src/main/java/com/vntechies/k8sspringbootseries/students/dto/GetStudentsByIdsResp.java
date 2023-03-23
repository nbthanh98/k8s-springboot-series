package com.vntechies.k8sspringbootseries.students.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetStudentsByIdsResp {
    private List<StudentDTO> students;
}
