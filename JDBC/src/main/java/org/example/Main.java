package org.example;

import org.example.respository.StudentRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        StudentRepository studentRepository = new StudentRepository();
        studentRepository.create();

//        studentRepository.update();

//        studentRepository.delete();

//        studentRepository.getByID();
    }
}
