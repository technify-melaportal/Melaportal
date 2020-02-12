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

	public Masthead save(Masthead masthead) {
		return mastheadDao.saveMasthead(masthead);
	}

	public Masthead getMasthead() {
		return mastheadDao.getMasthead();
	}
	
	public Masthead updateMasthead(Masthead masthead) {
		Masthead entity = mastheadDao.getId(masthead.getCompanyid());
		if(entity!=null){
			entity.setName(masthead.getName());
			entity.setShortname(masthead.getShortname());
			entity.setUrl(masthead.getUrl());
			entity.setLinkedin(masthead.getLinkedin());
			entity.setDescription(masthead.getDescription());
			entity.setAddress(masthead.getAddress());
			entity.setCity(masthead.getCity());
			entity.setState(masthead.getState());
			entity.setPincode(masthead.getPincode());
			entity.setCeoname(masthead.getCeoname());
			entity.setCeolinkedin(masthead.getCeolinkedin());
			entity.setCofoundername(masthead.getCofoundername());
			entity.setCofounderlinkedin(masthead.getCofounderlinkedin());
			//entity.setBusinesscard1(masthead.getBusinesscard1());
			//entity.setBusinesscard2(masthead.getBusinesscard2());
			//entity.setCompanylogo(masthead.getCompanylogo());
		}
		
		return entity;
	}
	
	public List<Masthead> getWarehouse(){
		return mastheadDao.getWarehouse();
	}
	
	@Override
	public Masthead getwarehouseid(int warehouseid) {
		// TODO Auto-generated method stub
		return mastheadDao.getwarehouseid(warehouseid);
	}
	
	public void updatePath(String name, String path, String path1, String path2, int companyid) {
		Masthead entity = mastheadDao.getId(companyid);
		if(entity!=null){
			entity.setBusinesscard1(path1);
			entity.setBusinesscard2(path2);
			entity.setCompanylogo(path);
		}
	}
	
	public void updateLogoPath(String name, String path, int companyid) {
		Masthead entity = mastheadDao.getId(companyid);
		if(entity!=null){
			entity.setCompanylogo(path);
		}
	}
}
