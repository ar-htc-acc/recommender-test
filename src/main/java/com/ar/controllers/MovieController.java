package com.ar.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ar.services.RecommendationService;

@Controller
@RequestMapping("/movie")
public class MovieController {

	private static final Logger log = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private RecommendationService recommendationService;
	
	@RequestMapping("/{movieId}")
	@ResponseBody
	public ResponseEntity<?> returnSuggestedMovies(@PathVariable Integer movieId) {
		
		log.info("Getting suggested movies.");
		
		return new ResponseEntity(recommendationService.getSuggestedMoviesForMovieId(movieId), HttpStatus.OK);
	}
}
