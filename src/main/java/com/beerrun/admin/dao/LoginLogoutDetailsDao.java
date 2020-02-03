package com.beerrun.admin.dao;

import java.util.List;

import com.beerrun.model.LoginLogoutDetails;

public interface LoginLogoutDetailsDao {
	
	List<LoginLogoutDetails> getuserinouttime();
	
	void saveLoginAndLogOutDetails(LoginLogoutDetails loginLogoutDetails);
	
	public String getMaximumRowId(boolean checker, String name);
	
	

}
