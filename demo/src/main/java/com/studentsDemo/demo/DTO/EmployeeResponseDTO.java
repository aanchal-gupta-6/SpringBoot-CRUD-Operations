package com.studentsDemo.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO {

     UUID empID;
     String empName;
     int age;
     String deptName;
     String empAddress;
}
