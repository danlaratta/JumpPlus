package com.jumpPlus.projects.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jumpPlus.projects.model.User;
import com.jumpPlus.projects.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUser(@PathVariable int id) {
		User user = service.getUserById(id);
		
		return ResponseEntity.status(200).body(user);
	}
	
	@PostMapping("/user/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
		User registeredUser = service.registerUser(user);
		
		return ResponseEntity.status(201).body(registeredUser);
	}
	
	@PostMapping("user/login")
	public ResponseEntity<?> loginUser(@Valid @RequestParam("email") String email, @RequestParam("password") String password) {
		Optional<User> loggedInUser = service.loginUser(email, password);
		
		return ResponseEntity.status(200).body(loggedInUser);
		
	}
	
	
	
}
