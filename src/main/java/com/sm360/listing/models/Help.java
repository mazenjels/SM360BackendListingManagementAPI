package com.sm360.listing.models;

import java.util.HashMap;
import java.util.Map;

public class Help {

	private String module;
	
	
	Map<String, String> routes = new HashMap<>();
	
	public Help() {
		
	}


	

	public String getModule() {
		return module;
	}




	public void setModule(String module) {
		this.module = module;
	}




	public Map<String, String> getRoutes() {
		return routes;
	}


	public void setRoute(Map<String, String> routes) {
		this.routes = routes;
	}
	
	
}
