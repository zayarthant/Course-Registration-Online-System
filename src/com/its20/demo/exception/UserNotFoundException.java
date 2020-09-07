package com.its20.demo.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 737277998147629622L;

	public UserNotFoundException(String message) {
		super(message);
	}

}
