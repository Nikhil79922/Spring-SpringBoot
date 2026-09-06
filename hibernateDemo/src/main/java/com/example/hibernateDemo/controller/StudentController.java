package com.example.hibernateDemo.controller;

import com.example.hibernateDemo.entity.Student;
import com.example.hibernateDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {

    //Services
    private StudentService studentService;

    @Autowired  // it is also done by default
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//    @PostMapping("{deptId}")
//    public ResponseEntity<String> addStudent(@PathVariable Long deptId, @RequestBody Student student) {
//        System.out.println(student);
//        System.out.println(deptId);
//        studentService.create(deptId, student);
//        return new ResponseEntity<>("Student added successfully", HttpStatus.OK);
//
//    }

//    @PostMapping("/addDeptAndStudent")
//    public ResponseEntity<String> addStudentAndDepartment(@RequestParam String deptName, @RequestBody Student student) {
//        System.out.println(student);
//        System.out.println(deptName);
//        studentService.createStudentAndDepartment(deptName, student);
//        return new ResponseEntity<>("Student and Department added successfully", HttpStatus.OK);
//
//    }

    @PostMapping("/addDeptAndStudentAndProfile")
    public ResponseEntity<String> addDeptAndStudentAndProfile(@RequestBody Student student) {
        studentService.createStudentWithDeptAndProfile(student);
        return new ResponseEntity<>("Student , Profile  and Department added successfully", HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable Long id) {
        Student s1 = studentService.findStudentById(id);
        return new ResponseEntity<>(s1, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents() {
        List<Student> students = studentService.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
