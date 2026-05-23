package com.studentsDemo.demo.ServiceImpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentsDemo.demo.DTO.EmployeeRequestDTO;
import com.studentsDemo.demo.DTO.EmployeeResponseDTO;
import com.studentsDemo.demo.Entity.Employee;
import com.studentsDemo.demo.Repository.EmployeeRepository;
import com.studentsDemo.demo.Service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO) {

        // Create Entity
        Employee emp1 = new Employee();

        emp1.setEmpName(employeeRequestDTO.getEmpName());
        emp1.setAge(employeeRequestDTO.getAge());
        emp1.setDeptName(employeeRequestDTO.getDeptName());
        emp1.setEmpAddress(employeeRequestDTO.getEmpAddress());

        // Save to DB
        Employee newEmployee = employeeRepository.save(emp1);

        // Create Response DTO
        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();

        employeeResponseDTO.setEmpID(newEmployee.getEmpID());
        employeeResponseDTO.setEmpName(newEmployee.getEmpName());
        employeeResponseDTO.setAge(newEmployee.getAge());
        employeeResponseDTO.setDeptName(newEmployee.getDeptName());
        employeeResponseDTO.setEmpAddress(newEmployee.getEmpAddress());

        return employeeResponseDTO;
    }

    @Override
public EmployeeResponseDTO getEmployee(UUID empID) {

    EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();

    Employee employee = employeeRepository.findById(empID)
            .orElseThrow(() -> new RuntimeException("Employee not found"));

    employeeResponseDTO.setEmpID(employee.getEmpID());

    employeeResponseDTO.setEmpName(employee.getEmpName());

    employeeResponseDTO.setAge(employee.getAge());

    employeeResponseDTO.setDeptName(employee.getDeptName());

    employeeResponseDTO.setEmpAddress(employee.getEmpAddress());

    return employeeResponseDTO;
}

@Override
public String deleteEmployee(UUID empID) {

    employeeRepository.deleteById(empID);

    return "Employee Deleted";
}

@Override
public EmployeeResponseDTO updateEmployee(
        UUID empID,
        EmployeeRequestDTO employeeRequestDTO) {

    Employee employee1 = employeeRepository.getReferenceById(empID);

    EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();

    // Update values
    employee1.setEmpName(employeeRequestDTO.getEmpName());
    employee1.setEmpAddress(employeeRequestDTO.getEmpAddress());
    employee1.setDeptName(employeeRequestDTO.getDeptName());
    employee1.setAge(employeeRequestDTO.getAge());

    // Save updated employee
    Employee newEmployee = employeeRepository.save(employee1);

    employeeResponseDTO.setEmpID(newEmployee.getEmpID());
    employeeResponseDTO.setEmpName(newEmployee.getEmpName());
    employeeResponseDTO.setAge(newEmployee.getAge());
    employeeResponseDTO.setDeptName(newEmployee.getDeptName());
    employeeResponseDTO.setEmpAddress(newEmployee.getEmpAddress());

    return employeeResponseDTO;
}

}