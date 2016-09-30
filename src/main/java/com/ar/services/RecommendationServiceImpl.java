package com.ar.services;

import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendationServiceImpl implements RecommendationService {

	private static final Logger log = LoggerFactory.getLogger(RecommendationServiceImpl.class);
	
	@Autowired
	private GenericItemBasedRecommender recommender;

	@Override
	public List<RecommendedItem> getSuggestedMoviesForMovieId(Integer movieId) {
		try {
			return recommender.mostSimilarItems(movieId, 5);
		} catch (TasteException e) {
			log.error("Cannot get recommendation.");
			return null;
		}
	}
	
	
}
