package com.example.CRUDops.service;

import com.example.CRUDops.dto.StudentRequestDTO;
import com.example.CRUDops.dto.StudentResponseDTO;
import com.example.CRUDops.entity.Student;
import com.example.CRUDops.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
        Student student = mapToEntity(studentDTO);

        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        System.out.println("Inside student service create");
        Student studentRepoResponse = studentRepository.save(student);
        System.out.println("Exiting student service create");
        StudentResponseDTO studentCreateServiceResponse = mapToDTO(studentRepoResponse);
        return studentCreateServiceResponse;
    }

    public Optional<Student> getOneStudent(Long id) {
        return studentRepository.findByIdAndDeletedIsFalse(id);
    }

    public List<Student> getAllStudent() {
        return studentRepository.findByDeletedIsFalse();
    }

    public Optional<Student> updateStudent(Long id, Student student) {
        Optional<Student> studentDetail = studentRepository.findByIdAndDeletedIsFalse(id);
        if (studentDetail.isPresent()) {
            Student updatedStudent = new Student();
            updatedStudent.setId(student.getId());
            updatedStudent.setSubject(student.getSubject());
            updatedStudent.setName(student.getName());
            updatedStudent.setEmail(student.getEmail());
            updatedStudent.setRollNo(student.getRollNo());
            updatedStudent.setAge(student.getAge());
            updatedStudent.setDeleted(student.getDeleted());
            return Optional.of(studentRepository.save(updatedStudent));
        }
        return studentDetail;

    }

    public boolean deleteStudent(Long id) {
        boolean exists = studentRepository.existsById(id);
        if(!exists){
            return false;
        }
         studentRepository.deleteById(id);
        return true;
    }

    public boolean softDeleteStudent(Long id) {
        Optional<Student> studentDetail = studentRepository.findByIdAndDeletedIsFalse(id);
        if (studentDetail.isPresent()) {
            Student updatedStudent =studentDetail.get();
            updatedStudent.setDeleted(true);
            studentRepository.save(updatedStudent);
            return true;
        }
        return false;
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
