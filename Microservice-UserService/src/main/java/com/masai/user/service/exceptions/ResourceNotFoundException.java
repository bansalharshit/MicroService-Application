package com.masai.user.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException() {
	super("Resource not found on server !!");	
	}
	
	public ResourceNotFoundException(String err) {
		super(err);
	}
}
