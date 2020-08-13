package com.cognizant.authenticationservice.exception;

@SuppressWarnings("serial")
public class UserAlreadyExistsException extends Exception {
	public UserAlreadyExistsException() {
		System.out.println("User Alredy Exists");
	}
}
