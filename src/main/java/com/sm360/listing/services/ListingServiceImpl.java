package com.sm360.listing.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm360.listing.exception.NoDatasFoundException;
import com.sm360.listing.models.Dealer;
import com.sm360.listing.models.DealerId;
import com.sm360.listing.models.Listing;
import com.sm360.listing.repository.ListingRepository;

@Service
public class ListingServiceImpl implements ListingService{

	@Autowired
	private ListingRepository lrepo;
	
	@Override
	public List<Listing> getListings() {
		// TODO Auto-generated method stub
		return lrepo.findAll() ;
	}

	@Override
	public Listing save(Listing l) {
		// TODO Auto-generated method stub
		return lrepo.save(l);
	}

	@Override
	public Listing publish(Listing l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Listing unpublish(Listing l) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Listing update(Listing l) {
		// TODO Auto-generated method stub
		return lrepo.save(l);
	}

	@Override
	public List<Listing> getListingsByDealerId(UUID dealerId) {
		// TODO Auto-generated method stub
		return lrepo.findByDealerId(dealerId);
	}

	@Override
	public Optional<Listing> findById(UUID id) {
		// TODO Auto-generated method stub
		Optional<Listing> listing  = lrepo.findById(id);
		if(listing.isPresent()) {
			return listing;
		}
		return null;
		//throw new NoDatasFoundException("No Listing not found with the id "+id.toString());
	}

	@Override
	public List<Listing> getListingsByDealerIdAndState(UUID dealerId, String state) {
		// TODO Auto-generated method stub
		return lrepo.findByDealerIdAndState(dealerId, state);
	}

	@Override
	public int countPublishedListingByDealerId(String state,UUID dealerId) {
		// TODO Auto-generated method stub
		return lrepo.countPublishedListingByDealerId(state, dealerId);
	}

	@Override
	public int checkIfListingIsAlreadyPublished(UUID id) {
		// TODO Auto-generated method stub
		return lrepo.checkIfListingIsAlreadyPublished(id);
	}

}
