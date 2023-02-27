package com.sm360.listing.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sm360.listing.models.Help;


public interface HelpService {

	 List<Help> availableRoutes();
}
