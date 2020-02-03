package com.beerrun.admin.service;

import java.util.List;

import com.beerrun.model.RoleDetails;

public interface RoleDetailServices {
	
	List<RoleDetails> getrolelist();
	
	RoleDetails findByroleId(int roleid);
	public List<Object[]> getroledetailsList();
	public List<Object> getroleIdUserdetailsList(int roleId);
	
	void saveRole(RoleDetails roleDetails);
	
}
