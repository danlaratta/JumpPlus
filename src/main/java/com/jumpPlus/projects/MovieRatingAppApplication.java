package com.jumpPlus.projects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jumpPlus.projects.model.User;
import com.jumpPlus.projects.service.UserService;

@SpringBootApplication
public class MovieRatingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieRatingAppApplication.class, args);
	}
	
	private UserService service;
	private User loggedInUser;
	
	public void mainMenu() {
		
	}
	
}
