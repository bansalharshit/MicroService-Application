package com.masai.user.service.services;

import java.util.List;

import com.masai.user.service.entities.User;

public interface UserService {

	public User saveUser(User user);
	public List<User> getAllUser();
	public User getUserDetails(String userId);
	public User deleteUser(String userId);
	public User updateUser(String userId);
}
