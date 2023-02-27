package com.sm360.listing.services;

import java.util.List;

import com.sm360.listing.models.Dealer;

public interface DealerService {

	List<Dealer> getDealers();

	Dealer save(Dealer d);
	
	Dealer get(String id);
	
	Dealer update(Dealer d);
}
