package com.vntechies.k8sspringbootseries.courses.services;

import com.vntechies.k8sspringbootseries.courses.dto.CoursesDto;
import com.vntechies.k8sspringbootseries.courses.dto.CreateCoursesReq;
import com.vntechies.k8sspringbootseries.courses.dto.JoinCourseReq;

public interface ICoursesService {
    CoursesDto createCourses(CreateCoursesReq req);

    CoursesDto joinCourses(JoinCourseReq req);
}
