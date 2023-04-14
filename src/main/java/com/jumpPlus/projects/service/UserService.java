package com.jumpPlus.projects.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumpPlus.projects.model.User;
import com.jumpPlus.projects.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;

	// GET user
	public User getUserById(int id) {
		
		Optional<User> foundUser = repo.findById(id);
		
		if(!foundUser.isPresent()) {
			// CREATE CUSTOM EXCEPTION
			System.out.println("no user");
		}
		
		return foundUser.get();
	}
	
	
	// CREATE user
	public User createUser(User user) {
		
		Optional<User> userExists = repo.findByEmail(user.getEmail());
		
		if(userExists.isPresent()) {
			// CREATE CUSTOM EXCEPTION
			System.out.println("user already exists");
		}
		
		return repo.save(user);
	}
	
	
	
	
	
}
