package com.example.CRUDops.controller;

import com.example.CRUDops.dto.StudentRequestDTO;
import com.example.CRUDops.dto.StudentResponseDTO;
import com.example.CRUDops.entity.Student;
import com.example.CRUDops.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/students")
public class StudentController {

    //Services
    private StudentService studentService;

    @Autowired  // it is also done by default
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //Create student
    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(@Valid @RequestBody StudentRequestDTO student) {
        System.out.println("Creating student " + student);
        StudentResponseDTO createdStudentDetails = studentService.create(student);
        System.out.println("Exiting student Repository create");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdStudentDetails);
    }

    //Read one student
    @GetMapping("/{id}")
    public ResponseEntity<Student> getOneStudent(@PathVariable long id) {
        Optional<Student> getOneStudentDetails = studentService.getOneStudent(id);

        if (getOneStudentDetails.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(getOneStudentDetails.get());
        }
        ;
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    //Read All student
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> getAllStudentDetails = studentService.getAllStudent();

        if (!getAllStudentDetails.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(getAllStudentDetails);
        };
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

    }

    //Update Student
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        studentDetails.setDeleted(false);
        Optional<Student> updatedStudentDetails = studentService.updateStudent(id, studentDetails);

        if (updatedStudentDetails.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(updatedStudentDetails.get());
        };
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    //Delete Ops
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        boolean deletedStudentDetails = studentService.deleteStudent(id);

        if (deletedStudentDetails) {
            return ResponseEntity.ok("Record deleted successfully");
        };
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Record not found");
    }

    //Soft Delete student
    @PatchMapping("/delete-soft/{id}")
    public ResponseEntity<String> softDeleteStudent(@PathVariable Long id) {
        boolean deletedStudentDetails = studentService.softDeleteStudent(id);

        if (deletedStudentDetails) {
            return ResponseEntity.ok("Record soft deleted successfully");
        };
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Record not found or Already deleted");
    }
}
