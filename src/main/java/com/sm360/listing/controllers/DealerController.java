package com.sm360.listing.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sm360.listing.repository.DealerRepository;

import java.util.List;

import javax.validation.Valid;

import com.sm360.listing.models.Dealer;
import com.sm360.listing.models.Listing;
import com.sm360.listing.services.DealerService;

@RestController
public class DealerController {

	private static final Logger logger = LoggerFactory.getLogger(DealerController.class);
	
	@Autowired
	private DealerService  dService;
	
	
	@GetMapping("/dealers")
	public List<Dealer> getCarDealers(){
		
		return dService.getDealers();
	}
	
	@PostMapping("/dealer/new")
	public ResponseEntity<Dealer> save(@Valid @RequestBody Dealer dealer) {
		
		return new ResponseEntity<Dealer>(dService.save(dealer),HttpStatus.CREATED);
	}
	
	
}
