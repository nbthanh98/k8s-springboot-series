package com.vntechies.k8sspringbootseries.courses.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vntechies.k8sspringbootseries.courses.clients.IStudentClient;
import com.vntechies.k8sspringbootseries.courses.clients.dto.GetStudentsByIdsReq;
import com.vntechies.k8sspringbootseries.courses.clients.dto.GetStudentsByIdsResp;
import com.vntechies.k8sspringbootseries.courses.clients.dto.StudentDTO;
import com.vntechies.k8sspringbootseries.courses.dto.*;
import com.vntechies.k8sspringbootseries.courses.entities.Courses;
import com.vntechies.k8sspringbootseries.courses.entities.CoursesMembers;
import com.vntechies.k8sspringbootseries.courses.exceptions.CustomException;
import com.vntechies.k8sspringbootseries.courses.repositories.ICoursesMembersRepository;
import com.vntechies.k8sspringbootseries.courses.repositories.ICoursesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CoursesServiceImpl implements ICoursesService {

    private final ObjectMapper objectMapper;
    private final IStudentClient iStudentClient;
    private final ICoursesRepository iCoursesRepository;
    private final ICoursesMembersRepository iCoursesMembersRepository;

    @Override
    public CourseDto createCourse(CreateCourseReq req) {
        Courses courses = new Courses();
        courses.setName(req.getName());
        courses.setAuthor(req.getAuthor());
        courses.setDesc(req.getDesc());
        Courses coursesDB = iCoursesRepository.save(courses);
        return objectMapper.convertValue(coursesDB, CourseDto.class);
    }

    @Override
    public CourseDetail getCourseDetailBy(Long courseId) {
        CourseDetail courseDetail = new CourseDetail();
        Courses courses = iCoursesRepository.findByID(courseId);
        if (Objects.isNull(courses)) {
            throw new CustomException("Courses not found!");
        }
        List<Long> membersId = new ArrayList<>();
        List<CoursesMembers> membersOfCourse = iCoursesMembersRepository.getAllById(courseId);
        for (CoursesMembers member : membersOfCourse) {
            membersId.add(member.getMemberId());
        }
        if (!membersId.isEmpty()) {
            GetStudentsByIdsResp studentsResp = iStudentClient.getStudentsByIds(new GetStudentsByIdsReq(membersId));
            List<MemberInfo> membersInfo = studentsResp.getStudents().stream()
                    .map(studentDTO -> objectMapper.convertValue(studentDTO, MemberInfo.class))
                    .collect(Collectors.toList());

            courseDetail.setMembers(membersInfo);
        }
        courseDetail.setCourse(objectMapper.convertValue(courses, CourseDto.class));
        return courseDetail;
    }

    @Override
    public CourseDto joinCourse(JoinCourseReq req) {
        Courses courses = iCoursesRepository.findByID(req.getCourseId());
        if (Objects.isNull(courses)) {
            throw new CustomException("Courses not found!");
        }
        StudentDTO studentDetail = iStudentClient.getStudentById(req.getStudentId());
        if (Objects.isNull(studentDetail)) {
            throw new CustomException("Student not found!");
        }
        CoursesMembers coursesMember = new CoursesMembers(courses.getId(), studentDetail.getId());
        iCoursesMembersRepository.save(coursesMember);
        return objectMapper.convertValue(courses, CourseDto.class);
    }
}
