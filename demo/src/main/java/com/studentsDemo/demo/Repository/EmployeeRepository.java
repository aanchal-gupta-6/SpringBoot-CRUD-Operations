package com.studentsDemo.demo.Repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.studentsDemo.demo.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, UUID>{

}