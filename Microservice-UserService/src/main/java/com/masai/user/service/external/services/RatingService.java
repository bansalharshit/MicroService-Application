package com.masai.user.service.external.services;





import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.masai.user.service.entities.Rating;

@Service
@FeignClient(name="RATING-SERVICE")
public interface RatingService {

	//get
	
	
	//post
	
	@PostMapping("/ratings")
	public Rating createRating(Rating values);
	
	//PUT
	@PutMapping("/ratings/{ratingId}")
	public Rating updatingRating(@PathVariable("ratingId") String ratingId, Rating rating);
	
	@DeleteMapping("/ratings/{ratingId}")
	public void deleteRating(@PathVariable String ratingId);
}
