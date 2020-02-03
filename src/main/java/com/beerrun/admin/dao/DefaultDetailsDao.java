package com.beerrun.admin.dao;

import java.util.List;

import com.beerrun.model.DefaultDetails;

public interface DefaultDetailsDao {
	
	List<DefaultDetails> getusersetupinfo();
	
	DefaultDetails findbyId(int id);
	
	void savesetup(DefaultDetails defaultDetails);
	
	
	DefaultDetails findByInvoiceNumber();
	
	Double getBrewHouseSize();
}
