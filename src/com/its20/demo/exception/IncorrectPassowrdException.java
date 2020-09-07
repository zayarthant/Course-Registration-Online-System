package com.its20.demo.exception;

public class IncorrectPassowrdException extends RuntimeException {

	private static final long serialVersionUID = 737277998147629622L;

	public IncorrectPassowrdException(String message) {
		super(message);
	}

}