package com.example.student.service;

import com.example.student.entity.Courses;
import com.example.student.entity.Student;

import java.util.List;

public interface CoursesService {

    public Courses createCourse(String courseName, Student student);
}