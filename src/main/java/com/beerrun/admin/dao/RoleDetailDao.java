package com.beerrun.admin.dao;

import java.util.List;

import com.beerrun.model.RoleDetails;

public interface RoleDetailDao {
	
	List<RoleDetails> getroledetails();
	
	RoleDetails findByroleId(int roleid);
	public List<Object[]> getroledetailsList();
	public List<Object> getroleIdUserdetailsList(int roleId);
	void saveRole(RoleDetails roleDetails);
}
