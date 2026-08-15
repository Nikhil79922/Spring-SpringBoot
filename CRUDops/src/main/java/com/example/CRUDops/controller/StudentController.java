package com.example.CRUDops.controller;

import com.example.CRUDops.dto.ApiResponse;
import com.example.CRUDops.dto.StudentRequestDTO;
import com.example.CRUDops.dto.StudentResponseDTO;
import com.example.CRUDops.entity.Student;
import com.example.CRUDops.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    public ResponseEntity<ApiResponse<StudentResponseDTO>> createStudent(@Valid @RequestBody StudentRequestDTO student) {
        StudentResponseDTO createdStudentDetails = studentService.create(student);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<StudentResponseDTO>(true , HttpStatus.CREATED.getReasonPhrase() , createdStudentDetails , LocalDateTime.now()  , HttpStatus.CREATED.value() ));
    }

    //Read one student
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponseDTO>> getOneStudent(@Valid @PathVariable long id) {
        StudentResponseDTO getOneStudentDetails = studentService.getOneStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<StudentResponseDTO>(true , HttpStatus.OK.getReasonPhrase() , getOneStudentDetails , LocalDateTime.now()  , HttpStatus.OK.value() ));
    }

    //Read All student
    @GetMapping
    public ResponseEntity<ApiResponse<List<StudentResponseDTO>>> getAllStudent() {
        List<StudentResponseDTO> getAllStudentDetails = studentService.getAllStudent();
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<List<StudentResponseDTO>>(true , HttpStatus.OK.getReasonPhrase(), getAllStudentDetails , LocalDateTime.now()  , HttpStatus.OK.value() ));
    }

    //Update Student
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponseDTO>> updateStudent( @Valid @PathVariable Long id, @RequestBody StudentRequestDTO studentDetails) {

        StudentResponseDTO updatedStudentDetails = studentService.updateStudent(id, studentDetails);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse<StudentResponseDTO>(true , HttpStatus.OK.getReasonPhrase() , updatedStudentDetails , LocalDateTime.now()  , HttpStatus.OK.value() ));
    }

    //Delete Ops
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteStudent( @Valid @PathVariable Long id) {
         studentService.deleteStudent(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<String>(true , HttpStatus.OK.getReasonPhrase() , "Student Records deleted successfully with id: " + id , LocalDateTime.now()  , HttpStatus.OK.value() ));
    }

    //Soft Delete student
    @PatchMapping("/delete-soft/{id}")
    public ResponseEntity<ApiResponse<String>> softDeleteStudent(@Valid @PathVariable Long id) {
         studentService.softDeleteStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<String>(true , HttpStatus.OK.getReasonPhrase() , "Student Records soft deleted successfully with id: " + id , LocalDateTime.now() , HttpStatus.OK.value() ));
    }
}
