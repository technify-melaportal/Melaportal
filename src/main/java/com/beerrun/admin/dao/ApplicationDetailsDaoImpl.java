package com.beerrun.admin.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.beerrun.init.AbstractDao;
import com.beerrun.model.ApplicationDetails;

@Repository("applicationDetailsDao")
public class ApplicationDetailsDaoImpl extends AbstractDao<Integer, ApplicationDetails> implements ApplicationDetailsDao{
	
	@Override
	public ApplicationDetails getId(int id)
	{
		ApplicationDetails applicationDetails = getByKey(id);
		
		return applicationDetails;
	}
	@Override
	public ApplicationDetails saveApplicationDetails(ApplicationDetails applicationDetails) {
		save(applicationDetails);
		return applicationDetails;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ApplicationDetails> getShortlistedDetails() {
		Criteria criteria = createEntityCriteria()
				.add(Restrictions.eq("status", 1));
		List<ApplicationDetails> applicationDetails = (List<ApplicationDetails>) criteria.list();
		return applicationDetails;	
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ApplicationDetails> getInvitedDetails() {
		Criteria criteria = createEntityCriteria()
				.add(Restrictions.eq("status", 2));
		List<ApplicationDetails> applicationDetails = (List<ApplicationDetails>) criteria.list();
		return applicationDetails;	
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ApplicationDetails> getApplicationDetails() {
		Criteria criteria = createEntityCriteria()
				.add(Restrictions.eq("status", 3));
		List<ApplicationDetails> applicationDetails = (List<ApplicationDetails>) criteria.list();
		return applicationDetails;	
	}

}
