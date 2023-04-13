package com.jumpPlus.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jumpPlus.projects.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

	
	
}
