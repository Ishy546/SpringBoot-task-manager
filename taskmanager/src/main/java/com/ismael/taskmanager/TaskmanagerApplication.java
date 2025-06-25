package com.ismael.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class TaskmanagerApplication {

	public static void main(String[] args) {

		SpringApplication.run(TaskmanagerApplication.class, args);

	}

	@GetMapping("/")
	public String helloWorld(){return "hello world";};

}
