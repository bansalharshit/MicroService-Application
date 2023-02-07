package com.masai.user.service.implemetation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.masai.user.service.entities.Hotel;
import com.masai.user.service.entities.Rating;
import com.masai.user.service.entities.User;
import com.masai.user.service.exceptions.ResourceNotFoundException;
import com.masai.user.service.repositories.UserRepository;
import com.masai.user.service.services.UserService;



@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public User saveUser(User user) {
		String randomUserId=UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	// get single user 
	@Override
	public User getUserDetails(String userId) {
		// get user from database with the help of user repository
	User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user with given id is not found on server !! : "+userId));
	// fetch rating of the user from rating service
	
//	http://localhost:8083/ratings/users/62f0a0b6-56c2-4bcb-b295-d93423d71a2c
	
Rating[] ratingsofUser=restTemplate.getForObject("http://localhost:8083/ratings/users/"+user.getUserId(), Rating[].class);
logger.info("{} ",ratingsofUser);

List<Rating> ratings=Arrays.stream(ratingsofUser).toList();
List<Rating> ratingList=ratings.stream().map(rating->{
	// api call to hotel service to get the hotel
	
	// http://localhost:8082/hotels/4e93ceb0-8afb-45aa-a6f3-6f8097f7570b
	ResponseEntity<Hotel> getEntity=restTemplate.getForEntity("http://localhost:8082/hotels/"+rating.getHotelId(), Hotel.class);
	
	Hotel hotel=getEntity.getBody();
	logger.info("response state code: {} ",getEntity.getStatusCode());
	// set the hotel to rating
	rating.setHotel(hotel);
	// return the rating
	return rating;
}).collect(Collectors.toList());
user.setRatings(ratingList);
	return user;
	}

	@Override
	public User deleteUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
