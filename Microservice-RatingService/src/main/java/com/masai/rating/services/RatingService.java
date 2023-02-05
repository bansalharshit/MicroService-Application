package com.masai.rating.services;

import java.util.List;

import com.masai.rating.entities.Rating;

public interface RatingService {
// create rating
	public Rating create(Rating rating);
	// get all ratings
	public List<Rating>getRatings();
	
	// get all by userId
	public List<Rating>getRatingByUserId(String userId);
	// get all by Hotel
	
	public List<Rating> getRatingByHotelId(String hotelid);
}
