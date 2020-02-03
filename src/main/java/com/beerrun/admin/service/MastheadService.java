package com.beerrun.admin.service;

import java.util.List;

import com.beerrun.model.Masthead;

public interface MastheadService {
	
    Masthead getId(int companyId);
	
	void save(Masthead masthead);
	
	void updateMasthead(Masthead masthead);
	
	Masthead getMasthead();
	
	List<Masthead> getWarehouse();

	Masthead getwarehouseid(int warehouseid);
	

}
