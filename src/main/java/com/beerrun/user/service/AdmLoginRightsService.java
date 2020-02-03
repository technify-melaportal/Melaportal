package com.beerrun.user.service;

import java.util.List;

import com.beerrun.model.AdmLoginRights;


public interface AdmLoginRightsService {
	public AdmLoginRights getAdmLoginRights(String subquery);
	public List<AdmLoginRights> getAdmLoginRightsList(String subquery);
	
	public void saveLoginRights(AdmLoginRights admLoginRights);
	
}
