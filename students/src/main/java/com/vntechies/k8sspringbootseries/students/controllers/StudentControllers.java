package com.vntechies.k8sspringbootseries.students.controllers;

import com.vntechies.k8sspringbootseries.students.dto.CreateStudentRequest;
import com.vntechies.k8sspringbootseries.students.dto.GetStudentsByIdsReq;
import com.vntechies.k8sspringbootseries.students.dto.GetStudentsByIdsResp;
import com.vntechies.k8sspringbootseries.students.dto.StudentDTO;
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
    public ResponseEntity<StudentDTO> createStudent(@RequestBody CreateStudentRequest request) {
        return new ResponseEntity<>(iStudentService.createStudent(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return new ResponseEntity<>(iStudentService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/getStudentBy")
    public ResponseEntity<StudentDTO> getStudentById(@RequestParam(value = "studentId") String studentId) {
        return new ResponseEntity<>(iStudentService.getStudentById(studentId), HttpStatus.OK);
    }

    @PostMapping(value = "/getStudentsBy")
    public ResponseEntity<GetStudentsByIdsResp> getStudentsByIds(@RequestBody GetStudentsByIdsReq req) {
        return new ResponseEntity<>(new GetStudentsByIdsResp(iStudentService.getStudentsByIds(req.getStudentIds())), HttpStatus.OK);
    }
}
