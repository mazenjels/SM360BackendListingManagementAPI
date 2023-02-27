package com.sm360.listing.controllers;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sm360.listing.exception.ErrorResponse;
import com.sm360.listing.exception.ListingAlreadyPublishedException;
import com.sm360.listing.exception.NoDatasFoundException;
import com.sm360.listing.exception.TierLimitReachedException;
import com.sm360.listing.models.DealerId;
import com.sm360.listing.models.Listing;
import com.sm360.listing.models.State;
import com.sm360.listing.models.TierLimit;
import com.sm360.listing.services.ListingService;
import com.sm360.listing.services.TierLimitService;

@RestController
//@RequestMapping("/api/sm360")
public class ListingController {

	private static final Logger logger = LoggerFactory.getLogger(ListingController.class);

	@Autowired
	private ListingService listingService;

	@Autowired
	TierLimitService tierLimitservice;

	@GetMapping("/listings")
	public ResponseEntity<List<Listing>> getListings() {

		return new ResponseEntity<List<Listing>>(listingService.getListings(), HttpStatus.OK);
	}

	@GetMapping("/listing/{id}")
	public ResponseEntity<Listing> findById(@PathVariable("id") UUID id) {
		Optional<Listing> listing = listingService.findById(id);
		 ;

		if (listing != null)
			return new ResponseEntity<Listing>(listingService.findById(id).get(), HttpStatus.OK);
		else
			throw new NoDatasFoundException("No Listing found with the id "+id.toString());
		// else
		// if(listing.isPresent()) {
		
		// }

	}

	@GetMapping("/listing/findByDealerId")
	public ResponseEntity<List<Listing>> getListingsByDealerId(@RequestParam UUID dealerId) {

		return new ResponseEntity<List<Listing>>(listingService.getListingsByDealerId(dealerId), HttpStatus.OK);
	}

	@GetMapping("/listing/findByDealerIdAndState")
	public ResponseEntity<List<Listing>> getListingsByDealerIdAndState(@RequestParam UUID dealerId,
			@RequestParam String state) {

		return new ResponseEntity<List<Listing>>(listingService.getListingsByDealerIdAndState(dealerId, state),
				HttpStatus.OK);
	}

	@PutMapping("/listing/{id}")
	public ResponseEntity<Listing> update(@RequestBody Listing listing, @PathVariable("id") UUID id) {

		listing.setId(id);

		return new ResponseEntity<Listing>(listingService.update(listing), HttpStatus.OK);
	}

	@PostMapping("/listing/new")
	public ResponseEntity<Listing> save(@Valid @RequestBody Listing listing) {

		return new ResponseEntity<Listing>(listingService.save(listing), HttpStatus.CREATED);
	}

	@PatchMapping("/listing/publish/{listingId}/{dealerId}")
	public ResponseEntity<Listing> publish(@Valid @RequestBody Map<String, String> listingFields,
			@PathVariable("listingId") UUID listingId, @PathVariable("dealerId") UUID dealerId) {


		// Check dealer's tier limit.		
		boolean published = false;

		if (listingService.checkIfListingIsAlreadyPublished(listingId) == 1)
			published = true;

		if (published) {

			throw new ListingAlreadyPublishedException("This listing is already published");

		} else {
			TierLimit tierLimit = tierLimitservice.findByTierLimitDealerId(dealerId);

			int nbofPublishedListing = listingService.countPublishedListingByDealerId("published", dealerId);

			// System.out.println("Tier limit: " + tierLimit.getNbOfPublishedListing());
			// System.out.println("nbofPublishedListing: " + (nbofPublishedListing + 1));

			// System.out.println("comparaison : " + (nbofPublishedListing <=
			// tierLimit.getNbOfPublishedListing()));

			if (nbofPublishedListing < tierLimit.getNbOfPublishedListing()) {
				Optional<Listing> listing = listingService.findById(listingId);

				if (listing.isPresent()) {
					listingFields.put("state", State.published.getLabel());

					for (Map.Entry<String, String> entry : listingFields.entrySet()) {
						Field field = ReflectionUtils.findField(Listing.class, (String) entry.getKey());
						field.setAccessible(true);
						ReflectionUtils.setField(field, listing.get(), entry.getValue());
					}

					Listing updatedListing = listingService.save(listing.get());

					return new ResponseEntity<Listing>(updatedListing, HttpStatus.OK);
				}
			} else {

				throw new TierLimitReachedException(
						"You have reached the maximum tier limit. Please unpublish an older listing to publish a new one.");
			}
		}

		return null;

	}

	@PatchMapping("/listing/unpublish/{id}")
	public ResponseEntity<Listing> unpublish(@RequestBody Map<String, String> listingFields,
			@PathVariable("id") UUID id) {

		Optional<Listing> listing = listingService.findById(id);
		// System.out.println("Listing : "+listing);
		if (listing.isPresent()) {
			listingFields.put("state", State.draft.getLabel());

			for (Map.Entry<String, String> entry : listingFields.entrySet()) {
				Field field = ReflectionUtils.findField(Listing.class, (String) entry.getKey());
				field.setAccessible(true);
				ReflectionUtils.setField(field, listing.get(), entry.getValue());
			}
//			listingFields.forEach((key,value)->{
//				Field field = ReflectionUtils.findField(Listing.class,(String)key);
//				field.setAccessible(true);
//				ReflectionUtils.setField(field, listing.get(), value);
//			});
			Listing updatedListing = listingService.save(listing.get());

			return new ResponseEntity<Listing>(updatedListing, HttpStatus.OK);
		}
		return null;

	}

	@ExceptionHandler(value = ListingAlreadyPublishedException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ErrorResponse handleListingAlreadyPublishedException(ListingAlreadyPublishedException ex) {
		return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
	}

	@ExceptionHandler(value = TierLimitReachedException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ErrorResponse handleTierLimitReachedException(TierLimitReachedException ex) {
		return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
	}
	
	@ExceptionHandler(value = NoDatasFoundException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ErrorResponse handleTierNoDatasFoundException(NoDatasFoundException ex) {
		return new ErrorResponse(HttpStatus.NO_CONTENT.value(), ex.getMessage());
	}

}
