package com.jumpPlus.projects;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jumpPlus.projects.model.Movie;
import com.jumpPlus.projects.model.User;
import com.jumpPlus.projects.repository.MovieRepository;
import com.jumpPlus.projects.service.MovieService;
import com.jumpPlus.projects.service.UserService;

@SpringBootApplication
public class MovieRatingAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MovieRatingAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		appRunner();
	}
	
	@Autowired
	UserService service;
	
	@Autowired
	MovieRepository repo;
	
	Scanner scan = new Scanner(System.in);
	
	// tracks if app is running
	boolean appRunning = true;
	
	// tracks whether user is logged in
	boolean loggedIn = false;
	
	private void appRunner() {
		while(appRunning) {
			if(!loggedIn) {
				System.out.println("\n**********************");
				System.out.println("   Movie Rating App   ");
				System.out.println("**********************");
				System.out.println("1.) Login");
				System.out.println("2.) Register");
				System.out.println("3.) View Movies");
				System.out.println("4.) Exit");
				
			}
			else {
				System.out.println("\n**********************");
				System.out.println("   User's Ratings   ");
				System.out.println("**********************");
				
				System.out.printf("\n%1s %8s %8s","Movie", "Rating", "Total Ratings" );
			}
			
			String menuOption = scan.nextLine();
			
			switch(menuOption) {
			case "1":
				login();
				break;
			case "2":
				register();
				break;
			case "3":
				viewMovies();
				break;
			case "4":
				System.out.println("App Exited");
				appRunning = false;
				break;
			default:
				System.out.println("Invalid Menu Option Selected.");
				break;
			}
		}
		
	}
	
	public void register() {
		System.out.println("**************" + "\n   Register   " + "\n**************");
		System.out.println("Enter Name: ");
		String name = scan.nextLine();
		
		System.out.println("Enter Email: ");
		String email = scan.nextLine();
		
		System.out.println("Enter Password: ");
		String password = scan.nextLine();
		
		User user = new User(null, name, email, password, null);
		service.registerUser(user);
	}
	
	public void login() {
		System.out.println("***************" + "\n     Login     " + "\n***************");
		
		System.out.println("Enter Email: ");
		String email = scan.nextLine();
		
		System.out.println("Enter Password: ");
		String password = scan.nextLine();
		
		loggedIn = service.loginUser(email, password);
	}
	
	public List<Movie> viewMovies() {
		System.out.println("***************" + "\n     Movies     " + "\n***************");
		
		List<Movie> movies = repo.getAllMovies();
		
	    for (Movie movie : movies) {
	        System.out.println(movie.getTitle());
	    }
	    
	    return movies;
	}
	
	
}















