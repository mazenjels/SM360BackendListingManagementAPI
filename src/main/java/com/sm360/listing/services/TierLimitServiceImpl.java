package com.sm360.listing.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm360.listing.models.TierLimit;
import com.sm360.listing.repository.TierLimitRepository;

@Service
public class TierLimitServiceImpl implements TierLimitService {

	@Autowired
	TierLimitRepository tlRepo;

	@Override
	public TierLimit findByTierLimitDealerId(UUID dealerId) {

		return tlRepo.findByDealerId(dealerId);

	}

	@Override
	public TierLimit save(TierLimit tl) {
		// TODO Auto-generated method stub
		return tlRepo.save(tl);
	}

	@Override
	public TierLimit update(TierLimit tl) {

		// TODO Auto-generated method stub
		return tlRepo.save(tl);
	}

}
