package com.example.student;

import com.example.student.entity.Courses;
import com.example.student.entity.Student;
import com.example.student.service.impl.CoursesServiceImpl;
import com.example.student.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentApplication implements CommandLineRunner {
	@Autowired
	private StudentServiceImpl studentService;

	@Autowired
	private CoursesServiceImpl coursesService;



	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
//		Student student = studentService.createStudent("Henry", "Mitchel");
//		Student student1 = studentService.createStudent("Iren", "Holly");
//
//		Courses course = coursesService.createCourse("Java", student);
//		Courses course1 = coursesService.createCourse("HTML", student);
//		Courses course2 = coursesService.createCourse("Python", student);
//		Courses course3 = coursesService.createCourse("English", student);
//		Courses course4 = coursesService.createCourse("French", student1);
	}
}