package com.vntechies.k8sspringbootseries.students.entities;

import com.vntechies.k8sspringbootseries.students.dto.CreateStudentRequest;
import com.vntechies.k8sspringbootseries.students.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "dob")
    private String dateOfBirth;

    @Column(name = "hometown")
    private String hometown;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public static Student createFrom(CreateStudentRequest request) {
        Student student = new Student();
        student.setFullName(request.getFullName());
        student.setDateOfBirth(request.getDateOfBirth());
        student.setHometown(request.getHometown());
        student.setGender(request.getGender());
        return student;
    }
}

