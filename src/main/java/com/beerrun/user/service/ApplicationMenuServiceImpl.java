package com.beerrun.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beerrun.model.AdmLoginRights;
import com.beerrun.model.ApplicationMenu;
import com.beerrun.user.dao.ApplicationMenuDao;

@Service
@Transactional
public class ApplicationMenuServiceImpl implements ApplicationMenuService {

	@Autowired
	private ApplicationMenuDao applicationMenuDao;
	
	@Override
	public Map<String,String> getparentchildMaps(String orderby){
		return applicationMenuDao.getparentchildMaps(orderby);	
	}
	
	@Override
	public List<ApplicationMenu> getApplicationMenuList(String subquery){
		return applicationMenuDao.getApplicationMenuList(subquery);		
	}
	
	@Override
	public Map<String,String> getParentChildNavicationMap(String orderby,String Navids) {
		return applicationMenuDao.getParentChildNavicationMap(orderby,Navids);
	}
	
	@Override
	public ApplicationMenu getApplicationMenuBySubquery(String subquery)
	{
		return applicationMenuDao.getApplicationMenuBySubquery(subquery);
	}
	
	@Override
	public Map<String,String> getPartNavicationMap()
	{
		return applicationMenuDao.getPartNavicationMap();
	}

	@Override
	public int AddUpdate(ApplicationMenu dto) {
		
		return applicationMenuDao.AddUpdate(dto);
	}

	@Override
	public ApplicationMenu getVideoUrl(String href) {
	
		return applicationMenuDao.getVideoUrl(href);
	}
}
