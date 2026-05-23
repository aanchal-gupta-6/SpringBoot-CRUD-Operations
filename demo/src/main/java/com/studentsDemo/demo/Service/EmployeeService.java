package com.studentsDemo.demo.Service;

import java.util.UUID;

import com.studentsDemo.demo.DTO.EmployeeRequestDTO;
import com.studentsDemo.demo.DTO.EmployeeResponseDTO;

public interface EmployeeService {

    EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO);
    EmployeeResponseDTO getEmployee(UUID empID);

String deleteEmployee(UUID empID);

EmployeeResponseDTO updateEmployee(
        UUID empID,
        EmployeeRequestDTO employeeRequestDTO
);
    

}
