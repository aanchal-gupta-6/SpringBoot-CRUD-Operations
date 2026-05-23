package com.studentsDemo.demo.Service;

import java.util.UUID;

import com.studentsDemo.demo.DTO.StudentRequestDTO;
import com.studentsDemo.demo.DTO.StudentResponseDTO;

public interface StudentService {

    StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO);
   StudentResponseDTO getStudent(UUID enrollmentNO);
   String deleteStudent(UUID enrollmentNO);
   StudentResponseDTO updateStudent(UUID enrollmentNo, StudentRequestDTO studentRequestDTO);
}