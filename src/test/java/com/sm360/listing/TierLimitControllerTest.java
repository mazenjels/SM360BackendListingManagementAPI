package com.sm360.listing;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sm360.listing.models.TierLimit;
import com.sm360.listing.services.TierLimitServiceImpl;

@SpringBootTest

public class TierLimitControllerTest {

	@Autowired
	MockMvc mvc;
	
	@MockBean
	TierLimitServiceImpl tls;

	 @Autowired
	    ObjectMapper mapper;
	 
	 	
	
	@Test
	public void testRegisterNewTierLimit() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/tierslimit/4700b218-14bd-4498-a1c5-7223d0e1d673")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.dealerId").value("4700b218-14bd-4498-a1c5-7223d0e1d673"));
		
		
		//TierLimit t = new TierLimit();
		//t.setDealerId(UUID.fromString("4700b218-14bd-4498-a1c5-7223d0e1d673"));
		//t.setNbOfPublishedListing(5);
		
		//tls.save(t);
		
		//assertNotNull(tls.findByTierLimitDealerId(UUID.fromString("4700b218-14bd-4498-a1c5-7223d0e1d673")));
		
	}

}
