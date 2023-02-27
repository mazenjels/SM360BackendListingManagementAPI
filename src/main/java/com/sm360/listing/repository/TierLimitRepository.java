package com.sm360.listing.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sm360.listing.models.TierLimit;

public interface TierLimitRepository extends JpaRepository<TierLimit,String>{

	@Query(value = "SELECT t FROM TierLimit t  where t.dealerId = :dealerId")
	TierLimit findByDealerId(UUID dealerId);
	
}
