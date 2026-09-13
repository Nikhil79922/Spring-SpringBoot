package com.example.CRUDops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication /*(exclude = { DataSourceAutoConfiguration.class })*/
public class CruDopsApplication {
	/* Work
	 * 1. List my endPoint
	 * 2. Business logic
	 * 3. Interact with DB to store data
	 * 4. Response back to client (postman)
	 * */
	public static void main(String[] args) {
		SpringApplication.run(CruDopsApplication.class, args);
		System.out.println("Server Started At port 8080");
	}

}
