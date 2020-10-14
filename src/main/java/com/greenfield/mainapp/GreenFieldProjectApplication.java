package com.greenfield.mainapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.greenfield.repository.EnrolleeRepo;

@SpringBootApplication(scanBasePackages = "com.greenfield")
@EnableMongoRepositories(basePackageClasses = EnrolleeRepo.class)
@ComponentScan(basePackages = "com.greenfield")
public class GreenFieldProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreenFieldProjectApplication.class, args);
		
	}

}
