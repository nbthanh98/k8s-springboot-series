package com.vntechies.k8sspringbootseries.courses.clients.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetStudentsByIdsResp {
    private List<StudentDTO> students;
}
