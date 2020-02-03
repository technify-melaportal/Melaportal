package com.beerrun.user.dao;

import java.util.List;
import java.util.Map;

import com.beerrun.model.ApplicationMenu;


public interface ApplicationMenuDao {
	public Map<String,String> getparentchildMaps(String orderby);
	public List<ApplicationMenu> getApplicationMenuList(String subquery);
	public Map<String,String> getParentChildNavicationMap(String orderby,String Navids);
	public ApplicationMenu getApplicationMenuBySubquery(String subquery);
	public  Map<String,String> getPartNavicationMap();
	public int AddUpdate(ApplicationMenu dto);
	public ApplicationMenu getVideoUrl(String href);
}
