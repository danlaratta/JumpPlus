package com.jumpPlus.projects.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumpPlus.projects.model.Movie;
import com.jumpPlus.projects.model.Rating;
import com.jumpPlus.projects.model.User;
import com.jumpPlus.projects.repository.RatingRepository;

@Service
public class RatingService {
	
	@Autowired 
	RatingRepository repo;
	
	@Autowired
	UserService userService;
	
	@Autowired
	MovieService movieService;

	
	
	public Rating rateMovie(Rating rating, User u, Movie m) {
        User user = userService.getUserById(u.getId());
        Movie movie = movieService.getMovieById(m.getId());
        Rating existingRating = repo.findByUserAndMovie(user, movie);

        if (existingRating != null) {
        	System.out.println("This Movie Has Already Been Rated");
        }
        
        return repo.save(rating);
    }



	public void rateMovie(Integer rating, Optional<User> currentUser, Optional<Movie> movie) {
		// TODO Auto-generated method stub
		
	}
	
}
























