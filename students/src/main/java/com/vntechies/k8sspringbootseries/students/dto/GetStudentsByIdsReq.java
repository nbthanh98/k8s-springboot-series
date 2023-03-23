package com.vntechies.k8sspringbootseries.students.dto;

import lombok.Data;

import java.util.List;

@Data
public class GetStudentsByIdsReq {
    private List<Long> studentIds;
}
