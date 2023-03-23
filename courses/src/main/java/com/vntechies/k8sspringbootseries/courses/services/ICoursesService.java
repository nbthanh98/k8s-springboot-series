package com.vntechies.k8sspringbootseries.courses.services;

import com.vntechies.k8sspringbootseries.courses.dto.CourseDetail;
import com.vntechies.k8sspringbootseries.courses.dto.CourseDto;
import com.vntechies.k8sspringbootseries.courses.dto.CreateCourseReq;
import com.vntechies.k8sspringbootseries.courses.dto.JoinCourseReq;

public interface ICoursesService {
    CourseDto createCourse(CreateCourseReq req);

    CourseDetail getCourseDetailBy(Long courseId);

    CourseDto joinCourse(JoinCourseReq req);
}
