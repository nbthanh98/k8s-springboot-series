package com.vntechies.k8sspringbootseries.courses.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vntechies.k8sspringbootseries.courses.dto.CoursesDto;
import com.vntechies.k8sspringbootseries.courses.dto.CreateCoursesReq;
import com.vntechies.k8sspringbootseries.courses.entities.Courses;
import com.vntechies.k8sspringbootseries.courses.repositories.ICoursesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CoursesServiceImpl implements ICoursesService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ICoursesRepository iCoursesRepository;

    @Override
    public CoursesDto createCourses(CreateCoursesReq req) {
        Courses courses = new Courses();
        courses.setName(req.getName());
        courses.setAuthor(req.getAuthor());
        courses.setDesc(req.getDesc());
        courses.setCreateAt(LocalDateTime.now());
        return objectMapper.convertValue(iCoursesRepository.save(courses), CoursesDto.class);
    }


}
