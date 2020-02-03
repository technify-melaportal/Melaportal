package com.beerrun.admin.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.beerrun.init.AbstractDao;
import com.beerrun.model.DefaultPageValue;


@Repository("defaultPageValueDao")
public class DefaultPageValueDaoImpl extends AbstractDao<Integer, DefaultPageValue> implements DefaultPageValueDao{

	static final Logger logger = LoggerFactory.getLogger(DefaultPageValueDaoImpl.class);
	
	@Override
	public List<DefaultPageValue> getDefaultPageList() {
		String sql = "select * from am_defaultpagevalue where pagename!='' and pagename is not null order by pageid;";
		SQLQuery query = getSession().createSQLQuery(sql);
		query.addEntity(DefaultPageValue.class);
		List<DefaultPageValue> defaultPageList = query.list();
			
	
		return defaultPageList;
	}
	
	
}
