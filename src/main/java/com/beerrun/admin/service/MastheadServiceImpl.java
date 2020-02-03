package com.beerrun.admin.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beerrun.admin.dao.MastheadDao;
import com.beerrun.model.Masthead;

@Service("mastheadService")
@Transactional
public class MastheadServiceImpl implements MastheadService{
	
	@Autowired
	private MastheadDao mastheadDao;
	
	public Masthead getId(int companyid) {
		
		return mastheadDao.getId(companyid);
	}

	public void save(Masthead masthead) {
		mastheadDao.save(masthead);
	}

	public Masthead getMasthead() {
		return mastheadDao.getMasthead();
	}
	
	public void updateMasthead(Masthead masthead) {
		Masthead entity = mastheadDao.getId(masthead.getCompanyid());
		if(entity!=null){
			entity.setRefName(masthead.getRefName());
			entity.setCompanyName(masthead.getCompanyName());
			entity.setAdd1(masthead.getAdd1());
			entity.setAdd2(masthead.getAdd2());
			entity.setCity(masthead.getCity());
			entity.setState(masthead.getState());
			entity.setZip(masthead.getZip());
			entity.setPhone(masthead.getPhone());
			entity.setEmail(masthead.getEmail());
			entity.setWebsite(masthead.getWebsite());
			entity.setLicenseNo(masthead.getLicenseNo());
			System.out.println("country id---"+masthead.getCountryId());
			
		}
	}
	
	public List<Masthead> getWarehouse(){
		return mastheadDao.getWarehouse();
	}
	
	@Override
	public Masthead getwarehouseid(int warehouseid) {
		// TODO Auto-generated method stub
		return mastheadDao.getwarehouseid(warehouseid);
	}
}
