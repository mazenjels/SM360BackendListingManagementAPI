package com.sm360.listing.services;

import java.util.UUID;

import com.sm360.listing.models.TierLimit;

public interface TierLimitService {

	TierLimit findByTierLimitDealerId(UUID dealerId);
	
	TierLimit save(TierLimit tl);
	
	TierLimit update(TierLimit tl);
	
	
	
}
