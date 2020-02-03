package com.beerrun.admin.dao;

import java.util.List;

import com.beerrun.model.Masthead;


public interface MastheadDao {
	
	Masthead getId(int companyId);
	
	void save(Masthead masthead);
	
	Masthead getMasthead();
	
	public List<Masthead> getWarehouse();
	
	Masthead getwarehouseid(int warehouseid);

}
