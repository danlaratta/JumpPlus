package com.jumpPlus.projects.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@NotBlank
	private String title;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
	private List<Rating> ratings;

	public Movie () {
		
	}

	public Movie(Integer id, @NotBlank String title, List<Rating> ratings) {
		super();
		Id = id;
		this.title = title;
		this.ratings = ratings;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public Integer getId() {
		return Id;
	}

	@Override
	public String toString() {
		return "Movie [Id=" + Id + ", title=" + title + ", ratings=" + ratings + "]";
	}
	
}
