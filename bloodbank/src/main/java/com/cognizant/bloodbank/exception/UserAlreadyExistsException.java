package com.cognizant.bloodbank.exception;

@SuppressWarnings("serial")
public class UserAlreadyExistsException extends Exception {
	public UserAlreadyExistsException() {
		System.out.println("User Alresy Exists");
	}
}
