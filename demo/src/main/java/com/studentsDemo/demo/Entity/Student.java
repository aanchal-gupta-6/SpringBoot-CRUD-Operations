package com.studentsDemo.demo.Entity;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID enrollmentNO;
    
    @Column(name = "student_name", nullable = true)
    String studentName;

    @Column(name = "age", nullable = true)
    int age;

    @Column(name = "program_name", nullable = true)
    String programName;

    @Column(name = "student_address", nullable = true)
    String studentAddress;

    
}