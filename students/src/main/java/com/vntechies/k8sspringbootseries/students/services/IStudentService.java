package com.vntechies.k8sspringbootseries.students.services;

import com.vntechies.k8sspringbootseries.students.dto.CreateStudentRequest;
import com.vntechies.k8sspringbootseries.students.dto.StudentDTO;

import java.util.List;

public interface IStudentService {
    StudentDTO createStudent(CreateStudentRequest request);

    StudentDTO getStudentById(String studentId);

    List<StudentDTO> getStudentsByIds(List<Long> ids);

    List<StudentDTO> getAll();
}
