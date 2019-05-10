package com.example.safaricomHackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.safaricomHackathon.repository")
public class SafaricomHackathonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafaricomHackathonApplication.class, args);
	}

}
