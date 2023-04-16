package com.jumpPlus.projects.model;

import java.io.Serializable;
import java.util.Optional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class Rating implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(nullable = false)
	@Min(value = 0) @Max(value = 5)
	private Integer rating;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "movie_id", referencedColumnName = "id")
	private Movie movie;
	
	public Rating() {
		
	}

	public Rating(Integer id, @Min(0) @Max(5) Integer rating, User user, Movie movie) {
		super();
		Id = id;
		this.rating = rating;
		this.user = user;
		this.movie = movie;
	}


	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Optional<User> getUser() {
        return Optional.ofNullable(user);
    }

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Integer getId() {
		return Id;
	}

	@Override
	public String toString() {
		return "Rating [Id=" + Id + ", rating=" + rating + ", user=" + user + ", movie=" + movie + "]";
	}
}
