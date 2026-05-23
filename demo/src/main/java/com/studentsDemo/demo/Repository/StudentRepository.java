package com.studentsDemo.demo.Repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.studentsDemo.demo.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, UUID>{

}