package com.masai.hotel.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException() {
		super("Resource Not Found on given server");
	}
	
	public ResourceNotFoundException(String err) {
		super(err);
	}
}
