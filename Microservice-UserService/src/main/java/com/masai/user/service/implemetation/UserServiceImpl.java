package com.masai.user.service.implemetation;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.user.service.entities.User;
import com.masai.user.service.exceptions.ResourceNotFoundException;
import com.masai.user.service.repositories.UserRepository;
import com.masai.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
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

	@Override
	public User getUserDetails(String userId) {
	return userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user with given id is not found on server !! : "+userId));
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
