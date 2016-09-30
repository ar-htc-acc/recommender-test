package com.ar.schedulers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ar.repositories.RatingRepository;

@Component
public class UpdateMovieSimilarity {

	private static final Logger log = LoggerFactory.getLogger(UpdateMovieSimilarity.class);
	
	@Autowired
	private RatingRepository ratingRepository;
	
	
	// TODO
	// the database will be updated
	// generate update CSV data from the database, and update the bean as well (GenericItemBasedRecommender) 
	
	@Scheduled(initialDelay=3000, fixedRate=24*60*60*1000)
	public void test() {
		log.info("Scheduler check...");
	}
	
	/**
	 * Update the rating
	 */
	/*
	@Scheduled(initialDelay=3000, fixedRate=24*60*60*1000)
	public void updateRating() {
	    log.info("Updating rating...");
	    
	    try {
	    	BufferedReader br = new BufferedReader(new FileReader("D:/workspace/recommender/src/main/resources/static/u.data"));
	    	
	    	String line;
	    	while((line = br.readLine()) != null) {
	    		String[] values = line.split("\\t", -1);
	    		
	    		// user id | item id | rating | timestamp. 
	    		Rating rating = new Rating();
	    		rating.setUserId(Integer.valueOf(values[0]));
	    		rating.setMovieId(Integer.valueOf(values[1]));
	    		rating.setRating(Integer.valueOf(values[2]));
	    		
	    		// only save if the rating does not already exists in the table
	    		if (ratingRepository.countByUserIdAndMovieId(rating.getUserId(), rating.getMovieId()) == 0) {	    			
	    			ratingRepository.save(rating);
	    		}
	    		
	    	}
	    	
	    	br.close();
		} catch (Exception e) {
			log.error("Update rating not successful.");
		}
	    
	    log.info("Update rating done.");
	} */
		
	
	/**
	 * Run to create the CSV file the first time.
	 * 
	 * @param args
	 */
//	public static void main(String[] args) {
//		
//		System.out.println("Starting...");
//		
//		BufferedReader br = null;
//		BufferedWriter bw = null;
//		try {
//			br = new BufferedReader(new FileReader("C:/data/u.data"));
//			bw = new BufferedWriter(new FileWriter("C:/data/movies.csv"));
//			String line;
//			while((line = br.readLine()) != null) {
//				String[] values = line.split("\\t", -1);
//				bw.write(values[0] + "," + values[1] + "," + values[2] + "\n");
//			}
//			br.close();
//			bw.close();						
//		} catch (Exception e) {
//			System.err.println("An error occurred.");
//		}
//	
//		System.out.println("Done!");
//	}
}
