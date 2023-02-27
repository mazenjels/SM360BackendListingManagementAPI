package com.sm360.listing.exception;

public class NoDatasFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String message;
	
	
	public NoDatasFoundException(String message) {
		super();
		this.message = message;
	}
	
	public NoDatasFoundException() {

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
