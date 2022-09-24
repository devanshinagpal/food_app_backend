package com.project.foodapp.exception;

public class IdNotFoundException extends RuntimeException {

	String message ="No such Id is present";

	public IdNotFoundException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
