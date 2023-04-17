package com.jumpPlus.projects;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jumpPlus.projects.model.Movie;
import com.jumpPlus.projects.model.Rating;
import com.jumpPlus.projects.model.User;
import com.jumpPlus.projects.repository.MovieRepository;
import com.jumpPlus.projects.repository.UserRepository;
import com.jumpPlus.projects.service.MovieService;
import com.jumpPlus.projects.service.RatingService;
import com.jumpPlus.projects.service.UserService;

import jakarta.persistence.Id;

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
	UserRepository userRepo;
	
	@Autowired
	MovieRepository repo;
	
	@Autowired
	RatingService rService;
	
	
	Scanner scan = new Scanner(System.in);
	
	// tracks if app is running
	boolean appRunning = true;
	
	// tracks whether user is logged in
	boolean loggedIn = false;
	
	// tracks currently logged in user and their id
	Optional<User> currentUser;
	Integer currentUserId;
	
	
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
				
				System.out.printf("%-32s %-26s %-32s","Movie", "Rating", "Total Ratings" );
				System.out.println();
				getMovieRatings();
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
		currentUser = userRepo.findByEmail(email);
		currentUserId = userRepo.findByEmail(email).get().getId();
		
		
	}
	
	public List<Movie> viewMovies() {
		System.out.println("***************" + "\n     Movies     " + "\n***************");
		
		List<Movie> movies = repo.getAllMovies();
		
	    for (Movie movie : movies) {
	        System.out.println(movie.getTitle());
	    }
	    
	    return movies;
	}
	
	public List<Object[]> getMovieRatings() {
		List<Object[]> movieRatings = repo.getMovieDetails();
		
		int count = 0;
		
		for (Object[] m : movieRatings) {
	        Movie movie = (Movie) m[0];
	        Double avgRating = (Double) m[1];
	        Long totalRatings = (Long) m[2];
	        
	        count += 1;
	        
	        System.out.printf(count + ".) %-30s %-30s %-30s", movie.getTitle(), avgRating, totalRatings);
	        System.out.println();
	    }
		
		System.out.println("5.) Exit");
		
		String movieOption = scan.nextLine();
		
		switch(movieOption) {
		case "1":
			rateMovies(movieOption);
			break;
		case "2":
			rateMovies(movieOption);
			break;
		case "3":
			rateMovies(movieOption);
			break;
		case "4":
			rateMovies(movieOption);
			break;
		case "5":
			System.out.println("App Exited");
			appRunning = false;
			break;
		default:
			System.out.println("Invalid Menu Option Selected.");
			break;
		}

		
		return movieRatings;
	}
	
	public void rateMovies(String movieOption) {
		
		Optional<Movie> movie = repo.findById(Integer.parseInt(movieOption));
		Integer movieId = repo.findById(Integer.parseInt(movieOption)).get().getId();
		
		System.out.println();
		System.out.println("*****************************" + "\n    Rate Movie: "   + movie.get().getTitle() + "\n*****************************");
		
		System.out.println();
		
		System.out.println("0.) Really Bad");
		System.out.println("1.) Bad");
		System.out.println("2.) Not Good");
		System.out.println("3.) Okay");
		System.out.println("4.) Good");
		System.out.println("5.) Great");
		System.out.println("\n6.) Exit");
		
		String ratingOption = scan.nextLine();
		Integer rating = Integer.parseInt(ratingOption);
		
		switch(ratingOption) {
		case "0", "1", "2", "3", "4", "5": 
			rService.rateMovie(rating, currentUser, movie);
			System.out.println("movie rated");
			break;
		case "6":
			appRunning = false;
			break;
		default:
			System.out.println("Invalid Menu Option Selected.");
			break;
		}
	}
}















