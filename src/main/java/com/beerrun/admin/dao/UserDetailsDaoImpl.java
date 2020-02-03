package com.beerrun.admin.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.beerrun.common.BeerRunConstants;
import com.beerrun.init.AbstractDao;
import com.beerrun.model.UserDetails;



@Repository("userDetailsDao")
@SuppressWarnings("unchecked")
public class UserDetailsDaoImpl extends AbstractDao<Integer, UserDetails> implements UserDetailsDao {

	static final Logger logger = LoggerFactory.getLogger(UserDetailsDaoImpl.class);

	@Override
	public List<UserDetails> getUserDetails() {
		Criteria criteria = createEntityCriteria()
				.add(Restrictions.eq("status", BeerRunConstants.STATUS)).add(Restrictions.eq("adminstatus", "1"));
		List<UserDetails> userDetails =  criteria.list();

		return userDetails;
	}

	@Override
	public String getUserDefaultPage() {
		String sql = "SELECT DISTINCT defaultvalue from am_userdetails;";
		SQLQuery query = getSession().createSQLQuery(sql);
		
		String defaultpage =  (String) query.uniqueResult();

		return defaultpage;
	}
	@Override
	public int savenewuser(UserDetails userDetails) {
		// TODO Auto-generated method stub
		save(userDetails);
		
	
		String sql = "Select defaultvalue from am_userdetails where defaultvalue!='' and defaultvalue is not null limit 1;";
		SQLQuery query = getSession().createSQLQuery(sql);
		String defaultpage =  (String) query.uniqueResult();

		String sql1="update am_userdetails set defaultvalue = '"+defaultpage+"'";
		SQLQuery query1 = getSession().createSQLQuery(sql1);
		query1.executeUpdate();
		
		return userDetails.getUserrefno();
	}

	@Override
	public void edituser(UserDetails userDetails) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteuser(int userrefno) {
		
		try {
			String sql1="update am_userdetails set status='2'   WHERE userrefno = '"+userrefno+"'";
			SQLQuery query1 = getSession().createSQLQuery(sql1);
			query1.executeUpdate();
			
			String sql2="update adm_login_rights set status='2'   WHERE userId = '"+userrefno+"'";
			SQLQuery query2 = getSession().createSQLQuery(sql2);
			query2.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Override
	public UserDetails findById(int userrefno) {
		
		UserDetails userDetails=getByKey(userrefno);
		if(userDetails!=null)
		{
			Hibernate.initialize(userDetails.getUserrefno());
		}
		return userDetails;
	}

	@Override
	public void defaultValue(String defaultValue,String userName)
	{
		System.out.printf("DAO impl default value %s\n username in dao %s",defaultValue, userName);
		String sql = "update am_userdetails set defaultvalue='"+defaultValue+"';";
		/*If Needed for single/all user default value change the query with/without where condition*/
//		String sql = "update am_userdetails set defaultvalue='"+defaultValue+"' where name='"+userName+"';";
		SQLQuery query = getSession().createSQLQuery(sql);
		query.executeUpdate();
		
	}

	@Override
	public UserDetails findByName(String userName) {
		Criteria crit=createEntityCriteria();
		crit.add(Restrictions.eq("userName", userName)).add(Restrictions.eq("status",1));
		UserDetails userDetails=(UserDetails)crit.uniqueResult();
		if(userDetails!=null){
			Hibernate.initialize(userDetails.getUserName());
		}
		System.out.println("login enter file------->"+crit);
		return userDetails;
	}
	
	@Override
	public List<UserDetails> getRepnameList() {
		String sql = "select * from am_userdetails where status = '1' and adminstatus = '1' and type = '1' order by name;";
		SQLQuery query = getSession().createSQLQuery(sql);
		query.addEntity(UserDetails.class);
		List<UserDetails> repnameList = query.list();


		return repnameList;
	}

	@Override
	public UserDetails getUserLoginDetails(String userName, String password) {
		Criteria criteria = createEntityCriteria();
		UserDetails login = (UserDetails)criteria. 
				add(Restrictions.and(Restrictions.and(Restrictions.eq("userName", userName),
						Restrictions.eq("password", password),Restrictions.eq("status", 1)))).uniqueResult();
		return login;
	}

	@Override
	public List<UserDetails> getAllUsers() {

		return null;
	}

	@Override
	public UserDetails sendForgetPassword(String email) {
		Criteria criteria = createEntityCriteria();
		UserDetails userDetails = (UserDetails)criteria. 
				add(Restrictions.and(Restrictions.and(Restrictions.eq("email", email),Restrictions.eq("status", 1)))).uniqueResult();
		
		return userDetails;
	}

	@Override
	public void roleupdate(int roleid, int userid) {
		// TODO Auto-generated method stub
		
		try {
			
			
			String sql2="UPDATE adm_login_rights AS a,am_roledetails AS b SET a.navigation_ids=b.navigation_ids WHERE b.roleid='"+roleid+"' AND userid='"+userid+"';";
			SQLQuery query2 = getSession().createSQLQuery(sql2);
			query2.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Override
	public void deleterole(int roleid) {
		// TODO Auto-generated method stub
		
		try {
			
			
			String sql2="UPDATE am_roledetails set status='2' WHERE roleid='"+roleid+"' and status='1';";
			SQLQuery query2 = getSession().createSQLQuery(sql2);
			query2.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
		
	}


}
