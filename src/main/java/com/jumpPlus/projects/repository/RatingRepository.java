package com.jumpPlus.projects.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jumpPlus.projects.model.Movie;
import com.jumpPlus.projects.model.Rating;
import com.jumpPlus.projects.model.User;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

	// get ratings based on userId and movieId
	@Query("SELECT r FROM Rating r WHERE r.user.id = :userId AND r.movie.id = :movieId")
    List<Rating> findByUserIdAndMovieId(Integer userId, Integer movieId);
	
	@Query("SELECT r FROM Rating r WHERE r.user = :user AND r.movie = :movie")
    Rating findByUserAndMovie(@Param("user") User user, @Param("movie") Movie movie);
	
}
