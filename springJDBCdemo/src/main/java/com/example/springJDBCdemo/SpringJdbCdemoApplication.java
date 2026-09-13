package com.example.springJDBCdemo;

import com.example.springJDBCdemo.respository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbCdemoApplication {

	public static void main(String[] args) {
		ApplicationContext context =
				SpringApplication.run(SpringJdbCdemoApplication.class, args);

		StudentRepository studentRepository =
				context.getBean(StudentRepository.class);

		studentRepository.create();

//		studentRepository.update();

//        studentRepository.delete();

//        studentRepository.getByID();
	}

}
