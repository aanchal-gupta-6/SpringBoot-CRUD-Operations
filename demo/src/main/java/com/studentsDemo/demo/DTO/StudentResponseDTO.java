package com.studentsDemo.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDTO {

     UUID enrollmentID;
     String studentName;
     int age;
     String programName;
     String studentAddress;
     public void setEnrollmentNO(UUID enrollmentNO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setEnrollmentNO'");
     }
}