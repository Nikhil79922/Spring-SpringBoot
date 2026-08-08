package com.example.CRUDops.service;

import com.example.CRUDops.entity.Student;
import com.example.CRUDops.repository.StudentRepository;
import org.springframework.stereotype.Service;

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

    public Student create(Student student) {
        System.out.println("Inside student service create");
        Student studentResponse = studentRepository.save(student);
        System.out.println("Exiting student service create");
        return studentResponse;
    }

    public Optional<Student> getOneStudent(Long id) {
        return studentRepository.findById(id);

    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Optional<Student> updateStudent(Long id, Student student) {
        Optional<Student> studentDetail = studentRepository.findById(id);
        if (studentDetail.isPresent()) {
            Student updatedStudent = new Student();
            updatedStudent.setId(student.getId());
            updatedStudent.setSubject(student.getSubject());
            updatedStudent.setName(student.getName());
            updatedStudent.setEmail(student.getEmail());
            updatedStudent.setRollNo(student.getRollNo());
            updatedStudent.setAge(student.getAge());
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

}
