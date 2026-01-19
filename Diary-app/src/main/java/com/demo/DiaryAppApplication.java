package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.demo.dao") // Point this to your DAO package
public class DiaryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiaryAppApplication.class, args);
	}

}
