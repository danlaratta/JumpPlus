package com.jumpPlus.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jumpPlus.projects.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

	
	
}
