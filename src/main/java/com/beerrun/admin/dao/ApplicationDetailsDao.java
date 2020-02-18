package com.beerrun.admin.dao;

import java.util.List;

import com.beerrun.model.ApplicationDetails;

public interface ApplicationDetailsDao {
	
	public ApplicationDetails getId(int id);
	
	public ApplicationDetails saveApplicationDetails(ApplicationDetails applicationDetails);
	
	public List<ApplicationDetails> getShortlistedDetails();
	
	public List<ApplicationDetails> getInvitedDetails();
	
	public List<ApplicationDetails> getApplicationDetails();

}
