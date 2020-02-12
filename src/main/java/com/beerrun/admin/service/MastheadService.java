package com.beerrun.admin.service;

import java.util.List;

import com.beerrun.model.Masthead;

public interface MastheadService {
	
    Masthead getId(int companyId);
	
    Masthead save(Masthead masthead);
	
    Masthead updateMasthead(Masthead masthead);
	
	Masthead getMasthead();
	
	List<Masthead> getWarehouse();

	Masthead getwarehouseid(int warehouseid);
	
	public void updatePath(String name, String path, String path1, String path2, int companyid);
	
	public void updateLogoPath(String name, String path, int companyid);
	

}
