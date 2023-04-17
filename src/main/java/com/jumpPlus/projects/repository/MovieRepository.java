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
	
	
	// select movie, aggregate avg rating for movie, and total ratings for movie
	@Query("SELECT m, AVG(r.rating), COUNT(r) FROM Movie m LEFT JOIN m.ratings r GROUP BY m.id")
    List<Object[]> getMoviesWithAvgRatingAndTotalRatings();
	
	
}
