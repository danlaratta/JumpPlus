package com.jumpPlus.projects.model;

public class MovieRatingDetails {
	
	private Movie movie;
	private Double averageRating;
	private Long totalRatings;
	
	public MovieRatingDetails() {
		
	}

	public MovieRatingDetails(Movie movie, Double averageRating, Long totalRatings) {
		super();
		this.movie = movie;
		this.averageRating = averageRating;
		this.totalRatings = totalRatings;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}

	public Long getTotalRatings() {
		return totalRatings;
	}

	public void setTotalRatings(Long totalRatings) {
		this.totalRatings = totalRatings;
	}

	@Override
	public String toString() {
		return "MovieRatingDetails [movie=" + movie + ", averageRating=" + averageRating + ", totalRatings="
				+ totalRatings + "]";
	}
}
