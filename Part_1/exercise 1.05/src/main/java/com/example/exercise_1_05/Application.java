package com.example.exercise_1_05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		String port = System.getenv("PORT");
		if (port == null || port.isEmpty()) {
			port = "8080"; // Default port
		}
		System.out.println("Server started in port " + port);
	}

}
