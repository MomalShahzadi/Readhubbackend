package com.example.readhub.readhub_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.readhub.readhub_backend")
public class ReadhubBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadhubBackendApplication.class, args);
	}
}
