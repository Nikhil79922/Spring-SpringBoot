package com.example.demo.service;

import com.example.demo.annotation.TrackExecutionTime;
import com.example.demo.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @TrackExecutionTime(
            warnAfter = 1500,
            operation = "Create Student ops"
    )
    public Student createStudent(Student student) {
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }

return student;
    }
}
