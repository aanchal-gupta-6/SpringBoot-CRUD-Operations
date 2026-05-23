package com.studentsDemo.demo.ServiceImpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentsDemo.demo.DTO.StudentRequestDTO;
import com.studentsDemo.demo.DTO.StudentResponseDTO;
import com.studentsDemo.demo.Entity.Student;
import com.studentsDemo.demo.Repository.StudentRepository;
import com.studentsDemo.demo.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

 @Override
    public StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO) {

        // Create Entity
        Student student1 = new Student();

        student1.setStudentName(studentRequestDTO.getStudentName());
        student1.setAge(studentRequestDTO.getAge());
        student1.setProgramName(studentRequestDTO.getProgramName());
        student1.setStudentAddress(studentRequestDTO.getStudentAddress());

        // Save to DB
        Student newStudent = studentRepository.save(student1);

        // Create Response DTO
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();

        studentResponseDTO.setEnrollmentID(newStudent.getEnrollmentNO());
        studentResponseDTO.setStudentName(newStudent.getStudentName());
        studentResponseDTO.setAge(newStudent.getAge());
        studentResponseDTO.setProgramName(newStudent.getProgramName());
        studentResponseDTO.setStudentAddress(newStudent.getStudentAddress());

        return studentResponseDTO;
    }

    
 @Override
public StudentResponseDTO getStudent(UUID enrollmentNO) {

    StudentResponseDTO studentResponseDTO = new StudentResponseDTO();

    Student student = studentRepository.findById(enrollmentNO)
            .orElseThrow(() -> new RuntimeException("Student not found"));

    studentResponseDTO.setEnrollmentID(student.getEnrollmentNO());

    studentResponseDTO.setStudentName(student.getStudentName());

    studentResponseDTO.setAge(student.getAge());

    studentResponseDTO.setProgramName(student.getProgramName());

    studentResponseDTO.setStudentAddress(student.getStudentAddress());

    return studentResponseDTO;

}

@Override
public String deleteStudent(UUID enrollmentNO) {

     studentRepository.deleteById(enrollmentNO);
            return "Student Deleted";
}

@Override
public StudentResponseDTO updateStudent(
        UUID enrollmentNO,
        StudentRequestDTO studentRequestDTO) {

    Student student1 = studentRepository.getReferenceById(enrollmentNO);
     StudentResponseDTO studentResponseDTO=new StudentResponseDTO();     

    // Update values
    student1.setStudentName(studentRequestDTO.getStudentName());
    student1.setStudentAddress(studentRequestDTO.getStudentAddress());
    student1.setProgramName(studentRequestDTO.getProgramName());
    student1.setAge(studentRequestDTO.getAge());

    // Save updated student
    Student newStudent = studentRepository.save(student1);


    studentResponseDTO.setEnrollmentID(newStudent.getEnrollmentNO());
    studentResponseDTO.setStudentName(newStudent.getStudentName());
    studentResponseDTO.setAge(newStudent.getAge());
    studentResponseDTO.setProgramName(newStudent.getProgramName());
    studentResponseDTO.setStudentAddress(newStudent.getStudentAddress());

    return studentResponseDTO;
}

}



