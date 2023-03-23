package com.vntechies.k8sspringbootseries.courses.controllers;

import com.vntechies.k8sspringbootseries.courses.dto.*;
import com.vntechies.k8sspringbootseries.courses.services.ICoursesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/courses")
public class CoursesControllers {

    private final ICoursesService iCoursesService;

    public CoursesControllers(ICoursesService iCoursesService) {
        this.iCoursesService = iCoursesService;
    }

    @PostMapping(value = "/v1/createCourse")
    public ResponseEntity<BaseResponse<CourseDto>> createCourse(@RequestBody CreateCourseReq req) {
        return new ResponseEntity<>(BaseResponse.buildSuccessResp(iCoursesService.createCourse(req)), HttpStatus.OK);
    }

    @PostMapping(value = "/v1/joinCourse")
    public ResponseEntity<BaseResponse<CourseDto>> joinCourse(@RequestBody JoinCourseReq req) {
        return new ResponseEntity<>(BaseResponse.buildSuccessResp(iCoursesService.joinCourse(req)), HttpStatus.OK);
    }

    @GetMapping(value = "/v1/getCourseDetailBy")
    public ResponseEntity<BaseResponse<CourseDetail>> getCourseDetailBy(@RequestParam(name = "courseId") Long courseId) {
        return new ResponseEntity<>(BaseResponse.buildSuccessResp(iCoursesService.getCourseDetailBy(courseId)), HttpStatus.OK);
    }
}
