package com.example.student.rest;

import com.example.student.entity.Courses;
import com.example.student.entity.Student;
import com.example.student.service.impl.CoursesServiceImpl;
import com.example.student.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")

public class Controller {

    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private CoursesServiceImpl coursesService;

    @PostMapping("/")
    public ResponseEntity<Student> createStudent(@RequestParam String firstName, @RequestParam String lastName) {
        Student student = studentService.createStudent(firstName, lastName);
        return ResponseEntity.ok(student);
    }

    @PostMapping("/{studentId}/courses")
    public ResponseEntity<Courses> createCourse(@PathVariable Student student, @RequestParam String courseName) {
        Courses course = coursesService.createCourse(courseName, student);
        return ResponseEntity.ok(course);
    }

    @PostMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<Void> addCourseToStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
        studentService.addCourseToStudent(studentId, courseId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{studentId}/courses")
    public ResponseEntity<List<Courses>> getAllCoursesForStudent(@PathVariable Long studentId) {
        List<Courses> coursesList = studentService.getAllCoursesForStudent(studentId);
        return ResponseEntity.ok(coursesList);
    }

    @DeleteMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<Void> removeStudentFromCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        studentService.removeStudentFromCourse(studentId, courseId);
        return ResponseEntity.ok().build();
    }
}