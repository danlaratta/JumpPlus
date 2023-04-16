package com.jumpPlus.projects.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumpPlus.projects.model.Movie;
import com.jumpPlus.projects.model.Rating;
import com.jumpPlus.projects.model.User;
import com.jumpPlus.projects.repository.MovieRepository;
import com.jumpPlus.projects.repository.RatingRepository;
import com.jumpPlus.projects.repository.UserRepository;

@Service
public class RatingService {
	
	@Autowired 
	RatingRepository repo;
	
	@Autowired
	UserRepository uRepo;
	
	@Autowired
	MovieRepository mRepo;

	// create rating for movie by user
	public Rating createRating(Integer userId, Integer movieId, Integer rated) {
		// get user by id
		Optional<User> user = uRepo.findById(userId);
		
		// get movie by id
		Optional<Movie> movie = mRepo.findById(movieId);
		
		// creating rating
		Rating rating = new Rating();
		
		// set user who's rating movie
		 user.ifPresent(rating::setUser);
		
		// set movie being rated
		 movie.ifPresent(rating::setMovie);
		
		// save rating
		return repo.save(rating);
	}
	
}
























