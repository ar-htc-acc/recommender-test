package com.ar;

import java.io.File;
import java.io.IOException;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.ar.configuration.properties.DataConfigurationProperties;

@EnableScheduling
@SpringBootApplication
public class RecommenderApplication {
	
	private static final Logger log = LoggerFactory.getLogger(RecommenderApplication.class);
	
	@Autowired
	private DataConfigurationProperties dataConfigurationProperties;
			
	@Bean
	public TaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(5);
		executor.setMaxPoolSize(10);
		executor.setQueueCapacity(25);
		return executor;
	}
	
	@Bean
	public GenericItemBasedRecommender recommender() throws IOException {
		try {
			// .csv => (userId, movieId, rating)
			DataModel dm = new FileDataModel(new File(dataConfigurationProperties.getCsvFile()));
			ItemSimilarity sim = new LogLikelihoodSimilarity(dm);
			GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(dm, sim);
			
			// input: (target movie ID, top 5 similar movies)
			//List<RecommendedItem> recommendedItems = recommender.mostSimilarItems(1L, 5);
			
			return recommender;
			
		} catch (IOException e) {
			log.error("Critical error. Please re-start the program.");
			throw e;
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(RecommenderApplication.class, args);
	}
}
