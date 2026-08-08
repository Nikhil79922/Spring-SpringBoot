package com.example.CRUDops.repository;

import com.example.CRUDops.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    /* Work :-
     *  All DataBase work
     * */


//    public Student saveStudent(Student student) {
//        System.out.println("Inside student Repository create");
//        System.out.println("Exiting student Repository create");
//        Student savedStudent = new Student();
//        savedStudent.setAge(22);
//        savedStudent.setEmail("nikkssy.dev@gmail.com");
//        savedStudent.setName("Nikkssy");
//        savedStudent.setRollNo(69);
//        savedStudent.setSubject("MERN Full Stack");
//
//        return savedStudent;
//    }
}
