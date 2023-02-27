package com.sm360.listing.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.sm360.listing.models.Dealer;
import com.sm360.listing.models.DealerId;
import com.sm360.listing.models.Listing;

public interface ListingService {

	List<Listing> getListings();
	
	Listing save(Listing l);
	
	Listing publish(Listing l);
	
	Listing unpublish(Listing l);
	
	Optional<Listing> findById(UUID id);
	
	Listing update(Listing l);
	
	List<Listing>getListingsByDealerId(UUID dealerId);
	
	List<Listing> getListingsByDealerIdAndState(UUID dealerId, String state);
	
	int countPublishedListingByDealerId(String state,UUID dealerId);
	
	int checkIfListingIsAlreadyPublished(UUID id);
	
}
