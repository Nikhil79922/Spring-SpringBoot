package com.example.hibernateDemo.service;


import com.example.hibernateDemo.entity.Department;
import com.example.hibernateDemo.entity.Profile2;
import com.example.hibernateDemo.entity.Student;
import com.example.hibernateDemo.repository.DepartmentRepository;
import com.example.hibernateDemo.repository.Profile2Repository;
import com.example.hibernateDemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    /*Work :-
     * 1) Business logic
     * 2) Send request to repository to store the data in DB.
     * */
    private StudentRepository studentRepository;
    private DepartmentRepository departmentRepository;
    private Profile2Repository profile2Repository;

    public StudentService(
            StudentRepository studentRepository,
            DepartmentRepository departmentRepository,
            Profile2Repository profile2Repository
    ) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
        this.profile2Repository = profile2Repository;
    }

//    @Transactional
//    public Student create(Long deptId, Student student) {
//        Department department = departmentRepository.getByDepartmentId(deptId);
//        student.setDepartment(department);
//        department.getStudents().add(student);
//        studentRepository.save(student);
//        return student;
//    }

//    @Transactional
//    public Student createStudentAndDepartment(String deptName, Student student) {
//        Department dept = new Department();
//        dept.setName(deptName);
//        dept.getStudents().add(student);
//        student.setDepartment(dept);
//        departmentRepository.save(dept);
//        studentRepository.save(student);
//        return student;
//    }


    @Transactional
    public Student createStudentWithDeptAndProfile(Student student) {
        Department department = new Department();
        department.setName("CSE");

        Profile2 profile = new Profile2();
        profile.setBio("Hey Whatsup");

        student.setProfile(profile);
        student.setDepartment(department);
        departmentRepository.save(department);
        profile2Repository.save(profile);
        studentRepository.save(student);
        return student;
    }

    @Transactional
        public Student findStudentById(Long studentId) {
        Student s1 = studentRepository.findById(studentId);
        return s1;
    }

    @Transactional
    public List<Student> findAll() {
        List<Student> students = studentRepository.findAll();
        for (Student student : students) {
            System.out.println("No department query call");
            student.getDepartment().getName();
        }

        System.out.println("Now the Profiles will be FEtched :::::::::::---");

        return students;
    }


}
