package com.ar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ar.entities.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

	Long countByUserIdAndMovieId(Integer userId, Integer movieId);
}
