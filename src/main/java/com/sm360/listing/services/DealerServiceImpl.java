package com.sm360.listing.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm360.listing.models.Dealer;
import com.sm360.listing.repository.DealerRepository;

@Service
public class DealerServiceImpl implements DealerService{

	@Autowired
	private DealerRepository dRepo;
	
	
	@Override
	public List<Dealer> getDealers() {
		// TODO Auto-generated method stub
		return dRepo.findAll();
	}


	@Override
	public Dealer save(Dealer d) {
		// TODO Auto-generated method stub
		return dRepo.save(d);
	}


	@Override
	public Dealer get(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Dealer update(Dealer d) {
		// TODO Auto-generated method stub
		return null;
	}

}
