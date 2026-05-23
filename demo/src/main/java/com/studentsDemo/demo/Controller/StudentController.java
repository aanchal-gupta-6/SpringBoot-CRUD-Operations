package com.studentsDemo.demo.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentsDemo.demo.DTO.StudentRequestDTO;
import com.studentsDemo.demo.DTO.StudentResponseDTO;
//import com.studentsDemo.demo.Entity.Student;
import com.studentsDemo.demo.Service.StudentService;

@RestController

@RequestMapping("/api")

public class StudentController {

private StudentService studentService;

@Autowired

public StudentController(StudentService studentService){

this.studentService = studentService;

}
@PostMapping("/createStudent") 


    public ResponseEntity<StudentResponseDTO> createStudent(
            @RequestBody StudentRequestDTO studentRequestDTO) {

        StudentResponseDTO response = studentService.createStudent(studentRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


@GetMapping("/getStudent")
public ResponseEntity<StudentResponseDTO> getStudent(@RequestParam UUID enrollmentNO) {

    return new ResponseEntity<>(
            studentService.getStudent(enrollmentNO),
            HttpStatus.OK
    );
}

@DeleteMapping("/deleteStudent")
public ResponseEntity<String> deleteStudent(
        @RequestParam UUID enrollmentNO) {

    return new ResponseEntity<>(studentService.deleteStudent(enrollmentNO),HttpStatus.OK);
}

@PutMapping("/updateStudent")
public ResponseEntity<StudentResponseDTO> updateStudent(
        @RequestParam UUID enrollmentNO,
        @RequestBody StudentRequestDTO studentRequestDTO) {

    return new ResponseEntity<>(
            studentService.updateStudent(enrollmentNO, studentRequestDTO),
            HttpStatus.OK);
}
}