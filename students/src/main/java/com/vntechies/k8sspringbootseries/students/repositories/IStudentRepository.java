package com.vntechies.k8sspringbootseries.students.repositories;

import com.vntechies.k8sspringbootseries.students.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IStudentRepository extends JpaRepository<Student, UUID> {
}
