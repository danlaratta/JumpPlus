package com.jumpPlus.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jumpPlus.projects.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	
	
}
