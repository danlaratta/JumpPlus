package com.jumpPlus.projects.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jumpPlus.projects.model.Movie;
import com.jumpPlus.projects.service.MovieService;

@RestController
@RequestMapping("/api")
public class MovieController {
	
	@Autowired
	MovieService service;
	
	@GetMapping("/movies")
	public List<Movie> getAllMovies() {
		return service.getMovies();	
	}
}
