package com.beerrun.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beerrun.model.AdmLoginRights;
import com.beerrun.user.dao.AdmLoginRightsDao;

@Service
@Transactional
public class AdmLoginRightsServiceImpl implements AdmLoginRightsService {
	
	@Autowired
	private AdmLoginRightsDao admLoginRightsDao;

	@Override
	public AdmLoginRights getAdmLoginRights(String subquery) {
		return admLoginRightsDao.getAdmLoginRights(subquery);
	}
	@Override
	public List<AdmLoginRights> getAdmLoginRightsList(String subquery) {
		return admLoginRightsDao.getAdmLoginRightsList(subquery);
	}
	
	public void saveLoginRights(AdmLoginRights admLoginRights) {
		
		admLoginRightsDao.saveLoginRights(admLoginRights);
	}
	
}
