package com.vntechies.k8sspringbootseries.students.services;

import com.vntechies.k8sspringbootseries.students.dto.CreateStudentRequest;
import com.vntechies.k8sspringbootseries.students.dto.StudentResp;

import java.util.List;

public interface IStudentService {
    StudentResp createStudent(CreateStudentRequest request);

    List<StudentResp> getAll();
}
