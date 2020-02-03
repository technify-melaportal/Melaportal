package com.beerrun.admin.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import com.beerrun.common.BeerRunConstants;
import com.beerrun.init.AbstractDao;
import com.beerrun.model.RoleDetails;

@Repository("roleDetailDao")
public class RoleDetailsDaoImpl extends AbstractDao<Integer, RoleDetails> implements RoleDetailDao {

	@Override
	public List<RoleDetails> getroledetails() {
		// TODO Auto-generated method stub
		
		Criteria crit=createEntityCriteria();
		 crit.add(Restrictions.eq("status", BeerRunConstants.STATUS)).addOrder(Order.asc("roleName"));
		 List<RoleDetails> rolelist=(List<RoleDetails>) crit.list();
		return rolelist;
	}
	
	
	/*AdminEmailTemplates adminEmailTemplates=getByKey(id);
		
		if(adminEmailTemplates!=null)
		{
			Hibernate.initialize(adminEmailTemplates);
			
		}
		return adminEmailTemplates;
	}*/

	@Override
	public RoleDetails findByroleId(int roleid) {
		// TODO Auto-generated method stub
		
		RoleDetails roleDetails=getByKey(roleid);
		
		/*if(roleDetails!=null)
		{
			Hibernate.initialize(roleDetails);
		}*/
		return roleDetails;
	}
	
	
	
	@Override
	public List<Object[]> getroledetailsList() {

		Session session = getSession();
		List<Object[]> list = null;
//		StringBuffer query=new StringBuffer("");
		
		try {
			/*query.append(" SELECT a.roleid,a.rolename,b.navigation_ids,COUNT(b.rights_id) as count FROM "+
					" am_roledetails AS a "+
					" LEFT JOIN adm_login_rights AS b ON b.rights_id=a.roleid "+"WHERE  b.status='1'"+
					" GROUP BY a.roleid ");
			System.out.println("count query--->"+query);
			list = session.createSQLQuery(query.toString())
					.addScalar("roleid",StandardBasicTypes.STRING)
					.addScalar("rolename",StandardBasicTypes.STRING)
					.addScalar("navigation_ids",StandardBasicTypes.STRING)
					.addScalar("count",StandardBasicTypes.STRING)  
					.list();*/
			
			String sql = "SELECT roleid AS rid,rolename,(SELECT COUNT(userrefno) FROM am_userdetails WHERE roleid=rid and status=1 AND TYPE = 1 AND adminstatus = 1) AS noofusers FROM am_roledetails WHERE STATUS=1 ;";
			System.out.println("userlist----->"+sql);
			SQLQuery query1= getSession().createSQLQuery(sql);
			List userlist = query1.list();
			return userlist;
			
		}catch (Exception e) {e.printStackTrace();}
		finally 
		{
		//	session.close();
		}
		return list;
	}
	
	@Override
	public List<Object> getroleIdUserdetailsList(int roleId) {
		
		Session session = getSession();
		List<Object> list = null;
		StringBuffer query=new StringBuffer("");
		
		try {
			/*query.append(" SELECT CONCAT(a.firstname,' ',a.lastname) AS name1 " + 
					"FROM am_userdetails AS a " + 
					"RIGHT JOIN " + 
					"adm_login_rights AS b ON b.userId=a.userrefno " + 
					"WHERE  a.status='1' and b.rights_id="+roleId);
			
			list = session.createSQLQuery(query.toString())
					.addScalar("name1",StandardBasicTypes.STRING)
					.list();
			System.out.println("111111-------->"+query);
			System.out.println("222222-------->"+list);*/

			String sql = "select userrefno,username from am_userdetails where roleid='"+roleId+"' and status='1' and type=1 and adminstatus=1;";
			System.out.println("view users----->"+sql);
			SQLQuery query1= getSession().createSQLQuery(sql);
			List viewUsers = query1.list();
			return viewUsers;
		}catch (Exception e) {e.printStackTrace();}
		finally 
		{
			//	session.close();
		}
		return list;
	}


	@Override
	public void saveRole(RoleDetails roleDetails) {
		saveOrUpdate(roleDetails);
		
		
		Session session = getSession();
		String sql1 = "UPDATE am_roledetails AS a, adm_login_rights AS b SET b.navigation_ids=a.navigation_ids WHERE b.rights_id=a.roleid AND a.roleid='"+roleDetails.getRoleid()+"';";
		SQLQuery query1 = session.createSQLQuery(sql1);
		query1.executeUpdate();
		
	}

}
