package com.vntechies.k8sspringbootseries.courses.clients.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetStudentsByIdsReq {
    private List<Long> studentIds;
}
