package com.example.CRUDops.service;

import com.example.CRUDops.dto.StudentRequestDTO;
import com.example.CRUDops.dto.StudentResponseDTO;
import com.example.CRUDops.entity.Student;
import com.example.CRUDops.exception.GlobalException;
import com.example.CRUDops.exception.ResourceNotFoundException;
import com.example.CRUDops.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {
    /*Work :-
     * 1) Business logic
     * 2) Send request to repository to store the data in DB.
     * */
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponseDTO create(StudentRequestDTO studentDTO) {
        boolean checkEmail = studentRepository.existsByEmail(studentDTO.getEmail());
        if (checkEmail) {
            throw new GlobalException.DuplicateException("Email already exists");
        }
        Student student = mapToEntity(studentDTO);
        Student studentRepoResponse = studentRepository.save(student);
        return mapToDTO(studentRepoResponse);
    }

    public StudentResponseDTO getOneStudent(Long id) {
        Student studentDetails =  studentRepository.findByIdAndDeletedIsFalse(id).orElseThrow(()-> new ResourceNotFoundException("Student not found with id: " + id));
        return mapToDTO(studentDetails);
    }

    public List<StudentResponseDTO> getAllStudent() {
        List<Student> studentsList = studentRepository.findByDeletedIsFalse();

        if (studentsList.isEmpty()) {
            throw new ResourceNotFoundException("Students not found");
        }
      return studentsList.stream().map(this::mapToDTO).toList();
    }

    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO student) {
        Student studentDetail = studentRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student not found with id: " + id));

            Student updatedStudent = new Student();
            updatedStudent.setId(id);
            updatedStudent.setSubject(studentDetail.getSubject());
            updatedStudent.setName(studentDetail.getName());
            updatedStudent.setEmail(studentDetail.getEmail());
            updatedStudent.setRollNo(studentDetail.getRollNo());
            updatedStudent.setAge(studentDetail.getAge());
            updatedStudent.setDeleted(studentDetail.getDeleted());

             Student updatedDetails = studentRepository.save(updatedStudent);
             return mapToDTO(updatedDetails);
    }

    public boolean deleteStudent(Long id) {
        boolean exists = studentRepository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Students not found");
        }
         studentRepository.deleteById(id);
        return true;
    }

    public boolean softDeleteStudent(Long id) {
       Student studentDetails  = studentRepository.findByIdAndDeletedIsFalse(id).orElseThrow(()-> new ResourceNotFoundException("Student not found with id: " + id));

        studentDetails.setDeleted(true);
            studentRepository.save(studentDetails);
            return true;
    }


    //Helper methods
    private Student mapToEntity(StudentRequestDTO studentDTO) {
        Student student = new Student();
        student.setSubject(studentDTO.getSubject());
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setRollNo(studentDTO.getRollNo());
        student.setAge(studentDTO.getAge());
        student.setDeleted(false);
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        return student;
    }

    private StudentResponseDTO mapToDTO(Student student) {
        StudentResponseDTO studentDTO = new StudentResponseDTO();
        studentDTO.setId(student.getId());
        studentDTO.setSubject(student.getSubject());
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setRollNo(student.getRollNo());
        studentDTO.setAge(student.getAge());
        studentDTO.setMessage("Students details are stored successfully");
        studentDTO.setCreatedAt(student.getCreatedAt());
        studentDTO.setUpdatedAt(student.getUpdatedAt());
        return studentDTO;
    }

}
