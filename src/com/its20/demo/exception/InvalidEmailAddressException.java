package com.its20.demo.exception;

public class InvalidEmailAddressException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5014376778272547314L;

	public InvalidEmailAddressException(String message) {
		super(message);
	}

}
