package com.studentsDemo.demo.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.studentsDemo.demo.DTO.EmployeeRequestDTO;
import com.studentsDemo.demo.DTO.EmployeeResponseDTO;
import com.studentsDemo.demo.Service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeResponseDTO> createEmployee(
            @RequestBody EmployeeRequestDTO employeeRequestDTO) {

        EmployeeResponseDTO response = employeeService.createEmployee(employeeRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/getEmployee")
public ResponseEntity<EmployeeResponseDTO> getEmployee(@RequestParam UUID empID) {

    return new ResponseEntity<>(
            employeeService.getEmployee(empID),
            HttpStatus.OK
    );
}

@DeleteMapping("/deleteEmployee")
public ResponseEntity<String> deleteEmployee(
        @RequestParam UUID empID) {

    return new ResponseEntity<>(
            employeeService.deleteEmployee(empID),
            HttpStatus.OK
    );
}

@PutMapping("/updateEmployee")
public ResponseEntity<EmployeeResponseDTO> updateEmployee(
        @RequestParam UUID empID,
        @RequestBody EmployeeRequestDTO employeeRequestDTO) {

    return new ResponseEntity<>(
            employeeService.updateEmployee(empID, employeeRequestDTO),
            HttpStatus.OK
    );
}
}