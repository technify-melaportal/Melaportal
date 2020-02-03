package com.beerrun.user.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.beerrun.init.AbstractDao;
import com.beerrun.model.AdmLoginRights;
import com.beerrun.model.ApplicationMenu;
import com.beerrun.model.UserDetails;


@Repository
public class AdmLoginRightsDaoImpl extends AbstractDao<Integer,AdmLoginRights > implements AdmLoginRightsDao {
	
	
	@Override
	public List<AdmLoginRights> getAdmLoginRightsList(String subquery){
		Session session = getSession();
		List<AdmLoginRights> list=null;
		StringBuffer query=new StringBuffer("");
		try {
			query.append(" from AdmLoginRights where 0=0 "+subquery);
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
	public AdmLoginRights getAdmLoginRights(String subquery){
		Session session = getSession();
		List<AdmLoginRights> list=null;
		StringBuffer query=new StringBuffer("");
		try {
			query.append(" from AdmLoginRights where 0=0 "+subquery);
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
	public void saveLoginRights(AdmLoginRights admLoginRights) {
		
		save(admLoginRights);
		System.out.println("rights id-----------"+admLoginRights.getRightsId());
		
		Session session = getSession();
		String sql1 = "UPDATE am_roledetails AS a, adm_login_rights AS b SET b.navigation_ids=a.navigation_ids WHERE b.rights_id=a.roleid AND a.roleid='"+admLoginRights.getRightsId()+"';";
		SQLQuery query1 = session.createSQLQuery(sql1);
		query1.executeUpdate();

	}


}
