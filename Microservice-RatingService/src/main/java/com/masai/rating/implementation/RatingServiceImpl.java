package com.masai.rating.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.rating.entities.Rating;
import com.masai.rating.repositories.RatingRespository;
import com.masai.rating.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRespository ratingRespository;
	
	@Override
	public Rating create(Rating rating) {
		return ratingRespository.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		return ratingRespository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return ratingRespository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelid) {
		return ratingRespository.findByHotelId(hotelid);
	}

}
