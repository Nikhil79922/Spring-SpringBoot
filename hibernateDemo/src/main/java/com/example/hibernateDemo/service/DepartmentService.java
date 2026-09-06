package com.example.hibernateDemo.service;

import com.example.hibernateDemo.entity.Department;
import com.example.hibernateDemo.entity.Student;
import com.example.hibernateDemo.repository.DepartmentRepository;
import com.example.hibernateDemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final StudentRepository studentRepository;

    public DepartmentService(DepartmentRepository departmentRepository, StudentRepository studentRepository) {
      this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
    }

//    @Transactional
//    public Department create(Department department) {
//        Student s1 = new Student();
//        s1.setName("John");
//        s1.setDepartment(department);
//
//        Student s2 = new Student();
//        s2.setName("Mark");
//        s2.setDepartment(department);
//
//        Student s3 = new Student();
//        s3.setName("Elise");
//        s3.setDepartment(department);
//
//        Student s4 = new Student();
//        s4.setName("Henry");
//        s4.setDepartment(department);
//
//        if (department.getStudents() == null) {
//            department.setStudents(new ArrayList<>());
//        }
//
//        department.getStudents().addAll(List.of(s1, s2, s3, s4));
//
//        department.getStudents().addAll(List.of(s1,s2,s3,s4));
//        departmentRepository.save(department);
////
////        studentRepository.save(s1);
////        studentRepository.save(s2);
////        studentRepository.save(s3);
////        studentRepository.save(s4);
//
//        return department;
//    }

    @Transactional
    public void removeDept(Long deptId) {

        Department department =
                departmentRepository.getByDepartmentId(deptId);

        if (department == null) {
            throw new RuntimeException("Department not found: " + deptId);
        }

        departmentRepository.delete(department);
    }

}
