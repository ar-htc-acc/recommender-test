package com.ar.services;

import java.util.List;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;

public interface RecommendationService {

	List<RecommendedItem> getSuggestedMoviesForMovieId(Integer movieId);

}
