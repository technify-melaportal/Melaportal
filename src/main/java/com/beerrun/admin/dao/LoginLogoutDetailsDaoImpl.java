package com.beerrun.admin.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.beerrun.common.Utils;
import com.beerrun.init.AbstractDao;
import com.beerrun.model.LoginLogoutDetails;

@Repository("loginlogoutDao")
@SuppressWarnings("unchecked")
public class LoginLogoutDetailsDaoImpl  extends AbstractDao<Integer, LoginLogoutDetails> implements LoginLogoutDetailsDao{

	@Override
	public List<LoginLogoutDetails> getuserinouttime() {
		String sql = "select id,rowid,name,version,logintime,logouttime,duration,DATE_FORMAT(dateadded,'%m/%d/%Y') as dateadded from am_loginlogoutdetails where NAME NOT IN ('demo','super admin') order by dateadded desc";
		SQLQuery query = getSession().createSQLQuery(sql);
		System.out.println("1------------>"+query);
		query.addEntity(LoginLogoutDetails.class);
		List<LoginLogoutDetails> loginLogoutDetails = query.list();
		return loginLogoutDetails;
	}

	@Override
	public void saveLoginAndLogOutDetails(LoginLogoutDetails loginLogoutDetails) {

		try {
			if(loginLogoutDetails.getlogintime() == null || loginLogoutDetails.getlogintime().equalsIgnoreCase("") ) {

				String startTime = (String) getSession().createQuery("SELECT logintime FROM LoginLogoutDetails where name = :name  and rowId = :rowId and logintime IS NOT NULL ")
						.setString("name",loginLogoutDetails.getName())
						.setString("rowId",loginLogoutDetails.getRowId()).uniqueResult();
				if(startTime!=null) {
					String duration = Utils.getTimeDifference(loginLogoutDetails.getlogouttime(), startTime );
					System.out.println("Duration--->"+duration);
					if(duration.equalsIgnoreCase("")) {
						
					}
					else {
					
					String hqlUpdate = "update am_loginlogoutdetails set logouttime = '"+loginLogoutDetails.getlogouttime()+"', duration = '"+duration+"' where logintime IS NOT NULL and name = '"+loginLogoutDetails.getName()+"' and rowId = '"+loginLogoutDetails.getRowId()+"' ";
					System.out.println("update query---->"+hqlUpdate);
					int update = getSession().createSQLQuery( hqlUpdate ).executeUpdate();
					
					}
					
				}else {
					
				
				}
				
			}else {
				save(loginLogoutDetails);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getMaximumRowId(boolean checker, String name) {
		Integer count = 0;
		try {
			if(checker) {
				count = ((Long) getSession().createQuery("select count(*) from LoginLogoutDetails").uniqueResult()).intValue();
			}else{
				Query query = getSession().createQuery("select MAX(rowId) from LoginLogoutDetails where name = :name");
				query.setParameter("name", name);
				//count = ((Long) getSession().createQuery("select max(rowId) from LoginLogoutDetails where name = :name ").uniqueResult()).intValue();
				System.out.println("============================"+((String) query.uniqueResult()));
				return ((String) query.uniqueResult());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(count);
	}
}
