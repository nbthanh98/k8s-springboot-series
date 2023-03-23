package com.vntechies.k8sspringbootseries.courses.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "courses_members")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoursesMembers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "member_id")
    private Long memberId;

    public CoursesMembers(Long courseId, Long memberId) {
        this.courseId = courseId;
        this.memberId = memberId;
    }
}
