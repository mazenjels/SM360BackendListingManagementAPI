package com.sm360.listing.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sm360.listing.models.Help;

@Service
public class HelpServiceImpl implements HelpService{

	@Override
	public List<Help> availableRoutes() {
		List<Help> helps = new ArrayList<>();
		Help help = new Help();
		Map<String, String> mapRoute = new HashMap<>();
		
		
		help.setModule("Listing");;	
		mapRoute.put("Get all listings - [GET]", "/api/sm360/listings");
		mapRoute.put("Get listing by id - [GET]", "/api/sm360/listing/{id}");
		mapRoute.put("Find listing by dealer Id - [GET]", "/api/sm360/listing/findByDealerId");
		mapRoute.put("Find listing by dealer id and state - [GET]", "/api/sm360/listing/findByDealerIdAndState");
		mapRoute.put("Update a listing - [PUT]", "/api/sm360/listing/{id}");
		mapRoute.put("Create a new listing - [POST]", "/api/sm360/listing/new");
		mapRoute.put("Publish a  listing - [PATCH]", "/api/sm360/listing/publish/{listingId}/{dealerId}");
		mapRoute.put("Unpublish a  listing - [PATCH]", "/api/sm360/listing/unpublish/{listingId}");
		help.setRoute(mapRoute);
		helps.add(help);
		
		help = new Help();
		mapRoute = new HashMap<>();
		help.setModule("Dealer");;	
		mapRoute.put("Get all dealers - [GET]", "/api/sm360/dealers");
		mapRoute.put("Register new dealer - [POST]", "/api/sm360/dealer/new");
		help.setRoute(mapRoute);
		helps.add(help);
		
		help = new Help();
		mapRoute = new HashMap<>();
		help.setModule("Tier limit");;	
		mapRoute.put("Get a dealer's tier limit - [GET]", "/api/sm360/tierslimit/{dealerId}");
		mapRoute.put("Register new dealer's tier limit - [POST]", "/api/sm360/tierslimit/new");
		help.setRoute(mapRoute);
		helps.add(help);
		return helps;
	}

}
