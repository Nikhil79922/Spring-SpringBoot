package org.example.service;

import org.example.entity.Student;
import org.example.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepo  studentRepo;
    public  StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student createStudent(Student student) {
        System.out.println(student.getEmail());
        System.out.println(student.getName());
        System.out.println(student.getId());
        return studentRepo.saveStudent(student);
    }

    public Student getStudent(Long id) {
        return studentRepo.findById(id);
    }

    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

}
