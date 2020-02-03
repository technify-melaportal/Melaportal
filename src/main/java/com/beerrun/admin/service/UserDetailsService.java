package com.beerrun.admin.service;

import java.util.List;

import com.beerrun.model.DefaultPageValue;
import com.beerrun.model.LoginLogoutDetails;
import com.beerrun.model.UserDetails;

public interface UserDetailsService {
	
	List<UserDetails> getUserDetails();
	String getPageDetails();
	/*TankList findByTank(String tankname);*/
	UserDetails findByUserName(String userName);
	UserDetails findById(int userrefno);
	int savenewuser(UserDetails userDetails);
	void edituser(UserDetails userDetails);
	void defaultpageno(String defaultpageno,String userName);
	void deleteuser(int userrefno);
	boolean isusernameunique(Integer userrefno,String userName);
	
	List<UserDetails> getRepnameList();
	public UserDetails getUserLoginDetails(String userName,String password);
	public List<UserDetails> getAllUsers();
	
	List<DefaultPageValue> getDefaultPageList();
	
	UserDetails sendForgetPassword(String email);
	
	void saveLoginAndLogoutDetails(LoginLogoutDetails loginLogoutDetails);
	
	public String getMaximumRowId(boolean checker, String name);
	
	public void roleupdate(int roleid,int userid);
	
	public void deleterole(int roleid);
	
	public void savePersonal(UserDetails userDetails);
	
	public void updatePhtoPath(String name, String path, UserDetails userDetails);
	
	public void updateVideoPath(UserDetails userDetails);
	
}
