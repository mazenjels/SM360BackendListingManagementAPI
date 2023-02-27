package com.sm360.listing.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sm360.listing.models.Dealer;

@Repository
public interface DealerRepository extends JpaRepository<Dealer, UUID> {

}
