package com.sm360.listing.exception;


public class ListingAlreadyPublishedException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String message;
	
	
	public ListingAlreadyPublishedException(String message) {
		super();
		this.message = message;
	}
	
	public ListingAlreadyPublishedException() {

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
