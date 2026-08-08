package com.example.CRUDops.controller;

import com.example.CRUDops.entity.Student;
import com.example.CRUDops.service.StudentService;
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
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println("Creating student " + student);
        Student createdStudentDetails = studentService.create(student);
        System.out.println("Exiting student Repository create");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdStudentDetails);
    }

    //Read one student
    @GetMapping("/get/{id}")
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
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> getAllStudentDetails = studentService.getAllStudent();

        if (!getAllStudentDetails.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(getAllStudentDetails);
        };
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

    }

    //Update Student
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        Optional<Student> updatedStudentDetails = studentService.updateStudent(id, studentDetails);

        if (updatedStudentDetails.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(updatedStudentDetails.get());
        };
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    //Delete Ops
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        boolean deletedStudentDetails = studentService.deleteStudent(id);

        if (deletedStudentDetails) {
            return ResponseEntity.ok("Record deleted successfully");
        };
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Record not found");
    }
}
