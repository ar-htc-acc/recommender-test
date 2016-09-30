package com.ar.models;

public class MovieSuggestion {

	public MovieSuggestion() {}
	
	public MovieSuggestion(Integer movieId, Double score) {
		this.movieId = movieId;
		this.score = score;
	}
	
	private Integer movieId;
	
	private Double score;

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}
	
}
