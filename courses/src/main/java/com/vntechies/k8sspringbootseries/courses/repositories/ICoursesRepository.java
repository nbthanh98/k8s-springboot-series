package com.vntechies.k8sspringbootseries.courses.repositories;

import com.vntechies.k8sspringbootseries.courses.entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ICoursesRepository extends JpaRepository<Courses, UUID> {
}
