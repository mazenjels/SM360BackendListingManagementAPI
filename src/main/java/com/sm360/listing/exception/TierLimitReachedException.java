package com.sm360.listing.exception;


public class TierLimitReachedException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String message;
	
	
	public TierLimitReachedException(String message) {
		super();
		this.message = message;
	}
	
	public TierLimitReachedException() {

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
