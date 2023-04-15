package com.jumpPlus.projects;


import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jumpPlus.projects.model.User;
import com.jumpPlus.projects.service.UserService;

@SpringBootApplication
public class MovieRatingAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MovieRatingAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
	
	@Autowired
	UserService service;
	
	private void mainMenu() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("/nMovie Rating App");
		System.out.println("\n1.) Login");
		System.out.println("2.) Register");
		System.out.println("3.) View Movies");
		System.out.println("4.) Exit");
		
		String menuOption = scan.nextLine();
		
		switch(menuOption) {
		case "1":
			System.out.println("Enter Name: ");
			String name = scan.nextLine();
			
			System.out.println("Enter Email: ");
			String email = scan.nextLine();
			
			System.out.println("Enter Password: ");
			String password = scan.nextLine();
			
			User user = new User(name, email, password);
			
		}
		
	}
	
	
}















