package com.vntechies.k8sspringbootseries.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vntechies.k8sspringbootseries.dto.CreateStudentRequest;
import com.vntechies.k8sspringbootseries.dto.StudentResp;
import com.vntechies.k8sspringbootseries.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final List<Student> STUDENTS = new ArrayList<>();

    @Override
    public StudentResp createStudent(CreateStudentRequest request) {
        Student student = Student.createFrom(request);
        STUDENTS.add(student);
        return objectMapper.convertValue(student, StudentResp.class);
    }

    @Override
    public List<StudentResp> getAll() {
        List<StudentResp> studentRespList = new ArrayList<>();
        for (Student student : STUDENTS) {
            StudentResp studentResp = objectMapper.convertValue(student, StudentResp.class);
            studentRespList.add(studentResp);
        }
        return studentRespList;
    }
}
