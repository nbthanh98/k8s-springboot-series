package com.vntechies.k8sspringbootseries.students.controllers;

import com.vntechies.k8sspringbootseries.students.dto.CreateStudentRequest;
import com.vntechies.k8sspringbootseries.students.dto.StudentResp;
import com.vntechies.k8sspringbootseries.students.services.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/students")
public class StudentControllers {

    private final IStudentService iStudentService;

    public StudentControllers(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }

    @PostMapping
    public ResponseEntity<StudentResp> createStudent(@RequestBody CreateStudentRequest request) {
        return new ResponseEntity<>(iStudentService.createStudent(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudentResp>> getAllStudents() {
        return new ResponseEntity<>(iStudentService.getAll(), HttpStatus.OK);
    }
}
