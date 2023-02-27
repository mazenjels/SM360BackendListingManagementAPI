package com.sm360.listing.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sm360.listing.models.Dealer;
import com.sm360.listing.models.DealerId;
import com.sm360.listing.models.Listing;

@Repository
public interface ListingRepository extends JpaRepository<Listing, String>{

	//We define a custom method (non-jpa) to filter retrieve listings
	@Query(value = "SELECT l FROM Listing l  where l.dealerId = :dealerId")
	List<Listing>findByDealerId(UUID dealerId);
	
	@Query(value = "SELECT l FROM Listing l  where l.dealerId = :dealerId and l.state=:state")
	List<Listing> findByDealerIdAndState(UUID dealerId, String state);
	
	@Query(value = "SELECT count(id) FROM Listing where state = :state and dealerId= :dealerId")
	int countPublishedListingByDealerId(@Param("state") String state, @Param("dealerId") UUID dealerId);

	@Query(value = "SELECT count(id) FROM Listing  where id = :id and state='published'")
	int checkIfListingIsAlreadyPublished(UUID id);
	
	@Query(value = "SELECT l FROM Listing l  where l.id = :id")
	Optional<Listing> findById(UUID id);
}
