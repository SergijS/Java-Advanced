package com.example.student.service.impl;

import com.example.student.entity.Courses;
import com.example.student.entity.Student;
import com.example.student.repository.CoursesRepository;
import com.example.student.repository.StudentRepository;
import com.example.student.service.CoursesService;
import com.example.student.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CoursesServiceImpl implements CoursesService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CoursesRepository coursesRepository;


    @Override
    public Courses createCourse (String courses, Student student){
        Courses newCourses = new Courses();
        newCourses.setCourses(courses);
        newCourses.setStudent(student);
        return coursesRepository.save(newCourses);
    }




}