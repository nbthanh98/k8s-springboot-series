package com.vntechies.k8sspringbootseries.courses.repositories;

import com.vntechies.k8sspringbootseries.courses.entities.CoursesMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICoursesMembersRepository extends JpaRepository<CoursesMembers, Long> {

    @Query(value = "SELECT * FROM courses_members cm WHERE cm.course_id = :courseId", nativeQuery = true)
    List<CoursesMembers> getAllById(@Param(value = "courseId") Long courseId);
}
