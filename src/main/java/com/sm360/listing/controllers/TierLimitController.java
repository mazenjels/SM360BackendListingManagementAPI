package com.sm360.listing.controllers;

import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sm360.listing.models.TierLimit;
import com.sm360.listing.services.TierLimitService;

@RestController
public class TierLimitController {

	private static final Logger logger = LoggerFactory.getLogger(TierLimitController.class);
	
	@Autowired
	TierLimitService service;
	
	@PostMapping("/tierslimit/new")
	public ResponseEntity<TierLimit> save(@Valid @RequestBody TierLimit tiersLimit) {
		
		return new ResponseEntity<TierLimit>(service.save(tiersLimit),HttpStatus.CREATED);
	}
	
	@GetMapping("/tierslimit/{dealerId}")
	public ResponseEntity<TierLimit> getTiersLimitByDealerId(@PathVariable("dealerId") UUID dealerId){
		
		return new ResponseEntity<TierLimit>(service.findByTierLimitDealerId(dealerId),HttpStatus.OK);
	}
}
