package com.example.safaricomHackathon;

import com.google.gson.JsonObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class SafaricomHackathonApplication {

	@GetMapping("/")
	public String defaultController() {
		JsonObject mResponseObject = new JsonObject();
		mResponseObject.addProperty("status", "200");
		mResponseObject.addProperty("message", "Welcome to Safaricom Hackathon API");
		return String.valueOf(mResponseObject);
	}

	public static void main(String[] args) {
		SpringApplication.run(SafaricomHackathonApplication.class, args);
	}

}
