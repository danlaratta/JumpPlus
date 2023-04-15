package com.jumpPlus.projects.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumpPlus.projects.model.User;
import com.jumpPlus.projects.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;

	// get user
	public User getUserById(int id) {
		// find user by id
		Optional<User> user = repo.findById(id);
		
		// if no user is found with that id throw exception
		if(!user.isPresent()) {
			System.out.println("User does not exist.");
		}
		
		// return user if found
		return user.get();
	}
	
	
	// register (create) user
	public User registerUser(User user) {
		// find user by email
		Optional<User> userExists = repo.findByEmail(user.getEmail());
		
		// throw exception if that user/email already exists
		if(userExists.isPresent()) {
			System.out.println("User already exists");
		}
		
		// create user if they don't already exist
		return repo.save(user);
	}
	
	
	// login user
	public Optional<User> loginUser(String email, String password) {
		// find user by email
		Optional<User> loggingInUser = repo.findByEmail(email);
		
		// if user w/ email doesn't exist or entered password does not match found user throw exception
		if(!loggingInUser.isPresent() || !loggingInUser.get().getPassword().equals(password)) {
			System.out.println("Unsuccessful login attempt");
			
		}
		
		// return logged in user
		return loggingInUser;
		
	}
	
}
