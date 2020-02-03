package com.beerrun.admin.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.beerrun.init.AbstractDao;
import com.beerrun.model.DefaultDetails;

@Repository("defaultDetailsDao")
@SuppressWarnings("unchecked")
public class DafaultDetailsDaoImpl extends AbstractDao<Integer, DefaultDetails> implements DefaultDetailsDao {

	static final Logger logger = LoggerFactory.getLogger(DafaultDetailsDaoImpl.class);

	@Override
	public List<DefaultDetails> getusersetupinfo() {
		// TODO Auto-generated method stub

		Criteria crit=createEntityCriteria();
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.

		List<DefaultDetails> defaultDetails= (List<DefaultDetails>)crit.list();
		return defaultDetails;
	}

	@Override
	public void savesetup(DefaultDetails defaultDetails) {
		// TODO Auto-generated method stub

	}

	@Override
	public DefaultDetails findbyId(int id) {
		// TODO Auto-generated method stub
		DefaultDetails defaultDetails=getByKey(id);

		
		return defaultDetails;
	}

	
	
	

	@Override
	public DefaultDetails findByInvoiceNumber() {

		Criteria criteria = createEntityCriteria();
		DefaultDetails defaultDetails = (DefaultDetails) criteria.uniqueResult();

		return defaultDetails;
	}

	
	@Override
	public Double getBrewHouseSize() {
		String sql="select brewhousesize from am_defaultdetails";
		SQLQuery query = getSession().createSQLQuery(sql);
        List  brewhousesize=query.list();
		if(brewhousesize.get(0)!=null)
		return Double.parseDouble(brewhousesize.get(0).toString());
		else
			return 0.0;
	}
}
