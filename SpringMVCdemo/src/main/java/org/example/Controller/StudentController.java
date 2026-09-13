package org.example.Controller;

import org.example.entity.Student;
import org.example.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    };

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent() {
  return  ResponseEntity.ok(studentService.getAllStudent());
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getOneStudent(@PathVariable("id") Long id) { //cause Long 1 --> 1L , so needed to specify the one
        return  ResponseEntity.ok(studentService.getStudent(id));
    }


}
