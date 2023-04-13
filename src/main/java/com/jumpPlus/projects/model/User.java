package com.jumpPlus.projects.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@NotBlank
	private String username;
	
	@Pattern(regexp = "^(.+)@(\\S+) $")
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Rating> movieRatings;
	
	
	public User() {
		
	}

	public User(Integer id, @NotBlank String username, @Pattern(regexp = "^(.+)@(\\S+) $") String email,
			String password, List<Rating> movieRatings) {
		super();
		Id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.movieRatings = movieRatings;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Rating> getMovieRatings() {
		return movieRatings;
	}

	public void setMovieRatings(List<Rating> movieRatings) {
		this.movieRatings = movieRatings;
	}

	public Integer getId() {
		return Id;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", movieRatings=" + movieRatings + "]";
	}
	
}
