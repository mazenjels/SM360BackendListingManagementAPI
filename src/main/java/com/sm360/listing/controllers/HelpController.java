package com.sm360.listing.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sm360.listing.models.Help;
import com.sm360.listing.services.HelpService;

@RestController
public class HelpController {

	@Autowired
	private HelpService service;
	
	@GetMapping("/")
	public ResponseEntity<List<Help>> getHelp() {
		
		return new ResponseEntity<List<Help>>(service.availableRoutes(), HttpStatus.OK);
	}
}
