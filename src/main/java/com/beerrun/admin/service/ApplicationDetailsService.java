package com.beerrun.admin.service;

import java.util.List;

import com.beerrun.model.ApplicationDetails;
import com.beerrun.model.Studentheader;

public interface ApplicationDetailsService {
	
	public ApplicationDetails getId(int id);
	
	public ApplicationDetails saveApplicationDetails(ApplicationDetails applicationDetails);
	
	public List<ApplicationDetails> getShortlistedDetails();
	
	public List<ApplicationDetails> getInvitedDetails();
	
	public List<ApplicationDetails> getApplicationDetails();
	
	public Studentheader getStudentId(int id);
	
	public List<Studentheader> getStudentDetails();

}
