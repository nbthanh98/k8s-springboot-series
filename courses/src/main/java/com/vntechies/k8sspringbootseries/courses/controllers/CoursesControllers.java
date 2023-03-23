package com.vntechies.k8sspringbootseries.courses.controllers;

import com.vntechies.k8sspringbootseries.courses.dto.BaseResponse;
import com.vntechies.k8sspringbootseries.courses.dto.CoursesDto;
import com.vntechies.k8sspringbootseries.courses.dto.CreateCoursesReq;
import com.vntechies.k8sspringbootseries.courses.dto.JoinCourseReq;
import com.vntechies.k8sspringbootseries.courses.services.ICoursesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/courses")
public class CoursesControllers {

    private final ICoursesService iCoursesService;

    public CoursesControllers(ICoursesService iCoursesService) {
        this.iCoursesService = iCoursesService;
    }

    @PostMapping(value = "/v1")
    public ResponseEntity<BaseResponse<CoursesDto>> createCourses(@RequestBody CreateCoursesReq req) {
        return new ResponseEntity<>(BaseResponse.buildSuccessResp(iCoursesService.createCourses(req)), HttpStatus.OK);
    }

    @PostMapping(value = "/v1")
    public ResponseEntity<BaseResponse<CoursesDto>> joinCourses(@RequestBody JoinCourseReq req) {
        return new ResponseEntity<>(BaseResponse.buildSuccessResp(iCoursesService.createCourses(req)), HttpStatus.OK);
    }
}
