package com.beerrun.user.dao;

import java.util.List;

import com.beerrun.model.AdmLoginRights;


public interface AdmLoginRightsDao {
	public AdmLoginRights getAdmLoginRights(String subquery);
	public List<AdmLoginRights> getAdmLoginRightsList(String subquery);
	
	public void saveLoginRights(AdmLoginRights admLoginRights);
	
}
