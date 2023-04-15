package com.example.student.service;

import com.example.student.entity.Courses;
import com.example.student.entity.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(String firstName, String lastName);
    void addCourseToStudent(Long studentId, Long courseId);

    List<Courses> getAllCoursesForStudent(Long studentId);
    void removeStudentFromCourse(Long studentId, Long courseId);


}