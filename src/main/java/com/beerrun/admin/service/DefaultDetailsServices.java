package com.beerrun.admin.service;

import java.util.List;

import com.beerrun.model.DefaultDetails;

public interface DefaultDetailsServices {

	List<DefaultDetails> getusersetupinfo();
	
	void update(DefaultDetails defaultDetails);
	
	void updatedefault(DefaultDetails defaultDetails);
	
	DefaultDetails findbyId(int id);
	
	
	DefaultDetails findByInvoiceNumber();
	
	Double getBrewHouseSize();
		
}
