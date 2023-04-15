package com.example.student.repository;

import com.example.student.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository <Courses, Long> {
}
