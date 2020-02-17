package com.beerrun.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beerrun.admin.dao.ApplicationDetailsDao;
import com.beerrun.model.ApplicationDetails;

@Transactional
@Service("applicationDetailsService")
public class ApplicationDetailsServiceImpl implements ApplicationDetailsService{

	@Autowired
	private ApplicationDetailsDao applicationDetailsDao;
	
	@Override
	public ApplicationDetails getId(int id) {
		return applicationDetailsDao.getId(id);
	}

	@Override
	public ApplicationDetails saveApplicationDetails(ApplicationDetails applicationDetails) {
		return applicationDetailsDao.saveApplicationDetails(applicationDetails);
	}

	@Override
	public List<ApplicationDetails> getApplicationDetails() {
		return applicationDetailsDao.getApplicationDetails();
	}

}
