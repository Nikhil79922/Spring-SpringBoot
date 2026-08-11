package org.example.repository;

import org.example.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepo {
    private Map<Long , Student> studentDB;
    public StudentRepo(Map<Long , Student> studentDB) {
        this.studentDB = studentDB;
    }

    public Student saveStudent(Student student) {
        studentDB.put(student.getId(), student);
        return student;
    }

    public Student findById(Long id) {
        return studentDB.get(id);
    }

    public List<Student> findAll() {
        return new ArrayList<>(studentDB.values());
    }

}
