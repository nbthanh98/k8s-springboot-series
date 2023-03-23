package com.vntechies.k8sspringbootseries.courses.clients;

import com.vntechies.k8sspringbootseries.courses.clients.dto.GetStudentsByIdsReq;
import com.vntechies.k8sspringbootseries.courses.clients.dto.GetStudentsByIdsResp;
import com.vntechies.k8sspringbootseries.courses.clients.dto.StudentDTO;

public interface IStudentClient {
    StudentDTO getStudentById(String studentId);

    GetStudentsByIdsResp getStudentsByIds(GetStudentsByIdsReq req);
}
