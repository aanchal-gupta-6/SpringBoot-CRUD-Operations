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
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID empID;
    
    @Column(name = "emp_name", nullable = true)
    String empName;

    @Column(name = "age", nullable = true)
    int age;

    @Column(name = "dept_name", nullable = true)
    String deptName;

    @Column(name = "emp_address", nullable = true)
    String empAddress;

    
}