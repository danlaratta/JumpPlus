package com.jumpPlus.projects.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jumpPlus.projects.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	// get all movies
	@Query("SELECT m FROM Movie m")
	List<Movie> getAllMovies();
	
	
//	@Query("SELECT m.title, r.rating FROM movie m JOIN rating r ON m.id = r.movie_id")
//	List<Object[]> getMoviesAndRatings();
//	
	
	
}
