package com.vntechies.k8sspringbootseries.students.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vntechies.k8sspringbootseries.students.dto.CreateStudentRequest;
import com.vntechies.k8sspringbootseries.students.dto.StudentResp;
import com.vntechies.k8sspringbootseries.students.entities.Student;
import com.vntechies.k8sspringbootseries.students.repositories.IStudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private final IStudentRepository iStudentRepository;

    public StudentServiceImpl(IStudentRepository iStudentRepository) {
        this.iStudentRepository = iStudentRepository;
    }

    @Override
    public StudentResp createStudent(CreateStudentRequest request) {
        Student student = iStudentRepository.save(Student.createFrom(request));
        return objectMapper.convertValue(student, StudentResp.class);
    }

    @Override
    public List<StudentResp> getAll() {
        List<Student> students = iStudentRepository.findAll();
        List<StudentResp> studentRespList = new ArrayList<>();
        for (Student student : students) {
            StudentResp studentResp = objectMapper.convertValue(student, StudentResp.class);
            studentRespList.add(studentResp);
        }
        return studentRespList;
    }
}