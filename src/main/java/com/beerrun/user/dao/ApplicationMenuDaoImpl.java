package com.beerrun.user.dao;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import com.beerrun.init.AbstractDao;
import com.beerrun.model.AdmLoginRights;
import com.beerrun.model.ApplicationMenu;

@Repository
public class ApplicationMenuDaoImpl extends AbstractDao<Integer,ApplicationMenu >implements ApplicationMenuDao  {
	
	
	@Override
	public Map<String,String> getPartNavicationMap()
	{
		Map<String,String> ls=null;
		Session session = getSession();
		List<Object[]> list = null;
		StringBuffer query=new StringBuffer("");
		
		try {
			query.append("SELECT parent_navigation_id,GROUP_CONCAT(navigation_id) as groupconcate FROM arc_navigation WHERE is_leaf =0 and status='1' GROUP BY parent_navigation_id");
			list = session.createSQLQuery(query.toString())
					.addScalar("parent_navigation_id",StandardBasicTypes.STRING)
					.addScalar("groupconcate",StandardBasicTypes.STRING)  
					.list();
			
		}catch (Exception e) {e.printStackTrace();}
		finally 
		{
			if(list!=null) {
				ls=new LinkedHashMap<String, String>();
				for(Object[] obj:list)
				{
					ls.put(obj[0]+"", obj[1]+"");	
				}
			}
		//	session.close();
		}
		return ls;
	}
	

	@Override
	public Map<String,String> getparentchildMaps(String orderby){
		Map<String,String> parentchildmap=null;
		Session session = getSession();
		List<Object[]> list = null;
		StringBuffer query=new StringBuffer("");
		orderby=orderby.equalsIgnoreCase("")?"dsp_order ":orderby;
		try {
			query.append(" SELECT parent_navigation_id,GROUP_CONCAT(navigation_id ORDER BY "+orderby+")  as groupconcate" +
					" FROM arc_navigation where status='1' GROUP BY parent_navigation_id ORDER BY parent_navigation_id ");
			list = session.createSQLQuery(query.toString())
					.addScalar("parent_navigation_id",StandardBasicTypes.STRING)
					.addScalar("groupconcate",StandardBasicTypes.STRING)  
					.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if(list!=null) {
				parentchildmap=new LinkedHashMap<String, String>();
				for(Object[] obj:list)
				{
					//System.out.println("obj[0].toString()==>"+obj[0].toString());
					//System.out.println("obj[1].toString()==>"+obj[1].toString());
					parentchildmap.put(obj[0].toString(), obj[1].toString());	
				}
			}
			//session.close();
		}
		
		return parentchildmap;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String,String> getParentChildNavicationMap(String orderby,String Navids)
	{
		
		Map<String,String> parentchildmap=null;
		Session session = getSession();
		List<Object[]> list = null;
		StringBuffer query=new StringBuffer("");
		
		Navids=Navids.equalsIgnoreCase("")?"0":Navids;
		orderby=orderby.equalsIgnoreCase("")?"dsp_order ":orderby;
	
		try {
			query.append("SELECT parent_navigation_id,GROUP_CONCAT(navigation_id ORDER BY "+orderby+")  as groupconcate " +
					"FROM arc_navigation WHERE (is_leaf=0 OR navigation_id IN ("+Navids+")) and status='1' GROUP BY parent_navigation_id ORDER BY parent_navigation_id ");
			list = session.createSQLQuery(query.toString())
					.addScalar("parent_navigation_id",StandardBasicTypes.STRING)
					.addScalar("groupconcate",StandardBasicTypes.STRING).list();
			}catch (Exception e) {e.printStackTrace();}
		finally 
		{
			if(list!=null) {
				parentchildmap=new LinkedHashMap<String, String>();
				for(Object[] obj:list)
				{
					parentchildmap.put(obj[0]+"", obj[1]+"");	
				}
			}
			//session.close();
		}
		return parentchildmap;
	}
	
	
	@Override
	public List<ApplicationMenu> getApplicationMenuList(String subquery){
		Session session = getSession();
		List<ApplicationMenu> list=null;
		StringBuffer query=new StringBuffer("");
		try {
			query.append(" from ApplicationMenu where 0=0 "+subquery);
			
			list = session.createQuery(query.toString()).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			//session.close();
		}
		return list;
	}
	
	
	
	@Override
	public ApplicationMenu getApplicationMenuBySubquery(String subquery){
		Session session = getSession();
		List<ApplicationMenu> list=null;
		StringBuffer query=new StringBuffer("");
		try {
			query.append(" from ApplicationMenu where 0=0 "+subquery);
			list = session.createQuery(query.toString()).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			//session.close();
		}
		return list.isEmpty()?null:list.get(0);	
	}

	@Override
	public int AddUpdate(ApplicationMenu dto) {
		Session session = getSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(dto);
			session.getTransaction().commit();
	} catch (Exception e) {
		e.printStackTrace();
		session.getTransaction().rollback();
		return 0;
	} finally {
		//session.close();
	}
		return dto.getNavigationId();
	}


	@Override
	public ApplicationMenu getVideoUrl(String href) {
		
			Session session = getSession();
			ApplicationMenu uniqueresult=null;
			try {
				String sql="from ApplicationMenu where hrefLink=:hrefLinkField";
				Query query = session.createQuery(sql)
						.setString("hrefLinkField", href);
				  uniqueresult = (ApplicationMenu) query.uniqueResult();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally 
			{
				//session.close();
			}
			return uniqueresult;	
		}
	
}
