package com.masai.rating.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.masai.rating.entities.Rating;

@Repository
public interface RatingRespository extends MongoRepository<Rating, String> {
// custom finder methods
	
	public List<Rating> findByUserId(String UserId);
	
	public List<Rating>findByHotelId(String hotelId);
}
