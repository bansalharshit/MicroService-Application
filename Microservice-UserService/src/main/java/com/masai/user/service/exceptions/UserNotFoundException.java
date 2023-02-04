package com.masai.user.service.exceptions;

public class UserNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException() {
		
	}
	public UserNotFoundException(String err) {
		super(err);
	}
}
