package com.beerrun.admin.service;

import java.util.List;

import com.beerrun.model.ApplicationDetails;

public interface ApplicationDetailsService {
	
	public ApplicationDetails getId(int id);
	
	public ApplicationDetails saveApplicationDetails(ApplicationDetails applicationDetails);
	
	public List<ApplicationDetails> getApplicationDetails();

}
