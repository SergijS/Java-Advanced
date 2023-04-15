package com.example.student.service.impl;

import com.example.student.entity.Courses;
import com.example.student.entity.Student;
import com.example.student.exeptions.CourseExceptions;
import com.example.student.exeptions.StudentExceptions;
import com.example.student.repository.CoursesRepository;
import com.example.student.repository.StudentRepository;
import com.example.student.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CoursesRepository coursesRepository;

    @Override
    public Student createStudent(String firstName, String lastName){
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        return studentRepository.save(student);
    }

    @Override
    public void addCourseToStudent(Long studentId, Long courseId) {
        Student student = studentRepository.getById(studentId);
        Courses courses = coursesRepository.getById(courseId);
        student.getCoursesList().add(courses);
        studentRepository.save(student);
    }

           @Override
    public List<Courses> getAllCoursesForStudent(Long studentId) {
        Student student = studentRepository.getById(studentId);
        return student.getCoursesList();
    }

    @Override
    public void removeStudentFromCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow(StudentExceptions::new);
        Courses courses = coursesRepository.findById(courseId).orElseThrow(CourseExceptions::new);
        student.getCoursesList().remove(courses);
        studentRepository.save(student);
    }
}