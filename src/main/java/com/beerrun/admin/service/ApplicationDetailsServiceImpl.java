package com.beerrun.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beerrun.admin.dao.ApplicationDetailsDao;
import com.beerrun.admin.dao.StudentDetailsDao;
import com.beerrun.model.ApplicationDetails;
import com.beerrun.model.Studentheader;

@Transactional
@Service("applicationDetailsService")
public class ApplicationDetailsServiceImpl implements ApplicationDetailsService{

	@Autowired
	private ApplicationDetailsDao applicationDetailsDao;
	
	@Autowired
	private StudentDetailsDao studentDetailsDao;
	
	@Override
	public ApplicationDetails getId(int id) {
		return applicationDetailsDao.getId(id);
	}

	@Override
	public ApplicationDetails saveApplicationDetails(ApplicationDetails applicationDetails) {
		return applicationDetailsDao.saveApplicationDetails(applicationDetails);
	}

	@Override
	public List<ApplicationDetails> getShortlistedDetails() {
		return applicationDetailsDao.getShortlistedDetails();
	}

	@Override
	public List<ApplicationDetails> getInvitedDetails() {
		return applicationDetailsDao.getInvitedDetails();
	}

	@Override
	public List<ApplicationDetails> getApplicationDetails() {
		return applicationDetailsDao.getApplicationDetails();
	}

	@Override
	public Studentheader getStudentId(int id) {
		return studentDetailsDao.getId(id);
	}

	@Override
	public List<Studentheader> getStudentDetails() {
		return studentDetailsDao.getStudentDetails();
	}

}
