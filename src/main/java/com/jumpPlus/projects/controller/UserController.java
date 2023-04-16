package com.jumpPlus.projects.controller;

import java.util.List;

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
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return service.getUsers();	
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUser(@PathVariable int id) {
		User user = service.getUserById(id);
		
		return ResponseEntity.status(200).body(user);
	}
	
	@PostMapping("/user/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
		service.registerUser(user);
		
		return ResponseEntity.status(201).body("User Registered Successfully");
	}
	
	@PostMapping("user/login")
	public String loginUser(@Valid @RequestParam("email") String email, @RequestParam("password") String password) {
		service.loginUser(email, password);
		
		return "User Logged In Successfully";
		
	}
	
	
	
}
