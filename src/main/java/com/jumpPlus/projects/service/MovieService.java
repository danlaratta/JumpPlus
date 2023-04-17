package com.jumpPlus.projects.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumpPlus.projects.model.Movie;
import com.jumpPlus.projects.model.MovieRatingDetails;
import com.jumpPlus.projects.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository repo;
	
	// get all movies
	public List<Movie> getMovies() {
		return repo.getAllMovies();
	}
 	
	// get movie by id
	public Movie getMovieById(int id) {
		// find movie by id
		Optional<Movie> movie = repo.findById(id);
		
		if(!movie.isPresent()) {
			System.out.println("Movie does not exist.");
		}
		
		// return movie if found
		return movie.get();
	}
	
	// get movies ratings details
	public List<MovieRatingDetails> getMovieDetails() {
        List<Object[]> results = repo.getMovieDetails();
        List<MovieRatingDetails> movieDetailsList = new ArrayList<>();

        for (Object[] result : results) {
            Movie movie = (Movie) result[0];
            Double avgRating = (Double) result[1];
            Long totalRatings = (Long) result[2];
            movieDetailsList.add(new MovieRatingDetails(movie, avgRating, totalRatings));
        }

        return movieDetailsList;
    }
}













