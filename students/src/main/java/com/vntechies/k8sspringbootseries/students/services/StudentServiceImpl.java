package com.vntechies.k8sspringbootseries.students.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vntechies.k8sspringbootseries.students.dto.CreateStudentRequest;
import com.vntechies.k8sspringbootseries.students.dto.StudentDTO;
import com.vntechies.k8sspringbootseries.students.entities.Student;
import com.vntechies.k8sspringbootseries.students.repositories.IStudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements IStudentService {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private final IStudentRepository iStudentRepository;

    public StudentServiceImpl(IStudentRepository iStudentRepository) {
        this.iStudentRepository = iStudentRepository;
    }

    @Override
    public StudentDTO createStudent(CreateStudentRequest request) {
        Student student = iStudentRepository.save(Student.createFrom(request));
        return objectMapper.convertValue(student, StudentDTO.class);
    }

    @Override
    public StudentDTO getStudentById(String studentId) {
        Optional<Student> student = iStudentRepository.findById(Long.valueOf(studentId));
        return student.map(value -> objectMapper.convertValue(value, StudentDTO.class)).orElse(null);
    }

    @Override
    public List<StudentDTO> getStudentsByIds(List<Long> ids) {
        List<Student> students = iStudentRepository.findAllStudentsByIds(ids);
        return students.stream()
                .map(student -> objectMapper.convertValue(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> getAll() {
        List<Student> students = iStudentRepository.findAll();
        List<StudentDTO> studentRespList = new ArrayList<>();
        for (Student student : students) {
            StudentDTO studentResp = objectMapper.convertValue(student, StudentDTO.class);
            studentRespList.add(studentResp);
        }
        return studentRespList;
    }
}