package com.sm360.listing.models;

import java.util.StringJoiner;
import java.util.UUID;

public class DealerId {

	private UUID id;

	public DealerId(UUID id) {

		this.id = id;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return new StringJoiner(", ", DealerId.class.getSimpleName() + "[", "]").add(String.format("id=%s", id))
				.toString();
	}

}
