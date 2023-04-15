package com.example.student.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Table(name = "courses")
@ToString(exclude = "students")
@AllArgsConstructor
@NoArgsConstructor
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courses;

    @ManyToOne (optional = false)
    @JoinColumn(name = "students_id", foreignKey = @ForeignKey (name = "student_courses_fk"))
    private Student student;

    public Courses (String body){
        this.courses = courses;
    }
}
