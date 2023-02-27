package com.sm360.listing.models;

public enum State {
	draft("draft"),
	published("published");
	
	public final String label;
	
	private State(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
	
}
