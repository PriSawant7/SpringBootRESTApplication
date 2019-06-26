package com.springbootrestapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PlanttApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PlanttApplication.class, args);
	}

}
