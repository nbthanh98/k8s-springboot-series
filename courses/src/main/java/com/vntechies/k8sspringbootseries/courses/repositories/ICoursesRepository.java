package com.vntechies.k8sspringbootseries.courses.repositories;

import com.vntechies.k8sspringbootseries.courses.entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICoursesRepository extends JpaRepository<Courses, Long> {

    @Query(value = "SELECT * FROM courses c WHERE c.id = :id", nativeQuery = true)
    Courses findByID(@Param(value = "id") Long id);
}
