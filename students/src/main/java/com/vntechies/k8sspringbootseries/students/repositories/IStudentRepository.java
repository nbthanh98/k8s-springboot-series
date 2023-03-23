package com.vntechies.k8sspringbootseries.students.repositories;

import com.vntechies.k8sspringbootseries.students.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT * FROM students s WHERE s.id IN (:studentIds)", nativeQuery = true)
    List<Student> findAllStudentsByIds(@Param(value = "studentIds") List<Long> studentIds);
}
