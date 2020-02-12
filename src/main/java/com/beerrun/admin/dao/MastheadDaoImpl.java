package com.beerrun.admin.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.beerrun.init.AbstractDao;
import com.beerrun.model.Masthead;

@Repository("mastheadDao")
public class MastheadDaoImpl extends AbstractDao<Integer, Masthead> implements MastheadDao{
	
	static final Logger logger = LoggerFactory.getLogger(MastheadDaoImpl.class);
	
	@Override
	public Masthead getId(int companyid)
	{
		Masthead masthead = getByKey(companyid);
		
		return masthead;
	}
	@Override
	public Masthead saveMasthead(Masthead masthead) {
		save(masthead);
		return masthead;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Masthead getMasthead() {
		Criteria criteria = createEntityCriteria();
		List<Masthead> masthead = (List<Masthead>) criteria.list();
		return masthead.isEmpty()?null:masthead.get(0);	
	}
	@Override
	public List<Masthead> getWarehouse() {
		Criteria criteria = createEntityCriteria()
			.add(Restrictions.eq("type","Warehouse"));
			List<Masthead> masthead = (List<Masthead>) criteria.list();
			return masthead;	
	}
	
	@Override
	public Masthead getwarehouseid(int warehouseid) {
		// TODO Auto-generated method stub
		Masthead mastheadList = getByKey(warehouseid);
			
			return (Masthead) mastheadList;
		
		
	}
	

}
