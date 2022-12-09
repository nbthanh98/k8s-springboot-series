package com.vntechies.k8sspringbootseries.services;

import com.vntechies.k8sspringbootseries.dto.CreateStudentRequest;
import com.vntechies.k8sspringbootseries.dto.StudentResp;

import java.util.List;

public interface IStudentService {

    StudentResp createStudent(CreateStudentRequest request);

    List<StudentResp> getAll();
}
