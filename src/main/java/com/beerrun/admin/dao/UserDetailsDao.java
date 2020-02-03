package com.beerrun.admin.dao;

import java.util.List;

import com.beerrun.model.UserDetails;

public interface UserDetailsDao {
	
	List<UserDetails> getUserDetails();
	
	String getUserDefaultPage();
	
	UserDetails findById(int userrefno);
	
	UserDetails findByName(String userName);
	
	void defaultValue(String defaultValue,String userName);
	
	int savenewuser(UserDetails userDetails);
	
	void edituser(UserDetails userDetails);
	
	void deleteuser(int userrefno);
	
	List<UserDetails> getRepnameList();
	
	public UserDetails getUserLoginDetails(String userName, String password);
	
	public List<UserDetails> getAllUsers();
	
	UserDetails sendForgetPassword(String email);
	
	public void roleupdate(int roleid,int userid);
	
	public void deleterole(int roleid);

}
