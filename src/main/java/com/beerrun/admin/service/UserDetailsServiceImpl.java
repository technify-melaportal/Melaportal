package com.beerrun.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beerrun.admin.dao.DefaultPageValueDao;
import com.beerrun.admin.dao.LoginLogoutDetailsDao;
import com.beerrun.admin.dao.RoleDetailDao;
import com.beerrun.admin.dao.UserDetailsDao;
import com.beerrun.model.DefaultDetails;
import com.beerrun.model.DefaultPageValue;
import com.beerrun.model.LoginLogoutDetails;
import com.beerrun.model.RoleDetails;
import com.beerrun.model.UserDetails;

@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserDetailsDao userDetailsDao;

	@Autowired
	private RoleDetailDao roleDetailDao;
	
	@Autowired
	private DefaultPageValueDao defaultPageValueDao;

	@Autowired
	private LoginLogoutDetailsDao loginLogoutDetailsDao;

	public List<UserDetails> getUserDetails() {
		return userDetailsDao.getUserDetails();
	}
	
	public String getPageDetails() {
		return userDetailsDao.getUserDefaultPage();
	}

	@Override
	public int savenewuser(UserDetails userDetails) {

		RoleDetails entity = roleDetailDao.findByroleId(userDetails.getRoleid());

		if(entity != null) {
			System.out.println("enter the role entity inside"+entity.getRoleName()+"id values"+entity.getRoleid());
			userDetails.setAdminstatus("1");
			userDetails.setType("1");
			userDetails.setRoleid(entity.getRoleid());
			userDetails.setRole(entity.getRoleName());
		}

		return userDetailsDao.savenewuser(userDetails);


	}

	@Override
	public void edituser(UserDetails userDetails) 
	{
		
		UserDetails entity=userDetailsDao.findById(userDetails.getUserrefno());
		if(entity != null){
			entity.setEmail(userDetails.getEmail());

			RoleDetails roleentity = roleDetailDao.findByroleId(userDetails.getRoleid());

			if(roleentity != null) {

				entity.setRoleid(roleentity.getRoleid());
				entity.setRole(roleentity.getRoleName());
			}
		}
	}

	@Override
	public List<DefaultPageValue> getDefaultPageList() {
		
		return defaultPageValueDao.getDefaultPageList();
	}
	
	
	@Override
	public void defaultpageno(String defaultpageno,String userName) {
		
		System.out.println("Default value in service impl "+defaultpageno);
		System.out.println("Username in service impl"+userName);
		userDetailsDao.defaultValue(defaultpageno,userName);
			
	}
	
	
	@Override
	public void deleteuser(int userrefno) {
		
		userDetailsDao.deleteuser(userrefno);
	}

	@Override
	public boolean isusernameunique(Integer userrefno, String userName) {
		UserDetails userDetails=findByUserName(userName);
		return (userDetails==null||((userrefno!=null)) && (userDetails.getUserrefno()==userrefno));
	}

	@Override
	public UserDetails findByUserName(String userName) {
		 return userDetailsDao.findByName(userName);
	}

	@Override
	public UserDetails findById(int userrefno) {
		 return userDetailsDao.findById(userrefno);

	}

	public List<UserDetails> getRepnameList() {
		return userDetailsDao.getRepnameList();
	}

	@Override
	public UserDetails getUserLoginDetails(String userName, String password) {
		return userDetailsDao.getUserLoginDetails(userName,password);
	}

	@Override
	public List<UserDetails> getAllUsers() {
		return userDetailsDao.getAllUsers();
	}

	@Override
	public UserDetails sendForgetPassword(String email) {

		return userDetailsDao.sendForgetPassword(email);
	}

	@Override
	public void saveLoginAndLogoutDetails(LoginLogoutDetails loginLogoutDetails) {
		if(loginLogoutDetails != null) {
			loginLogoutDetailsDao.saveLoginAndLogOutDetails(loginLogoutDetails);
		}
	}

	@Override
	public String getMaximumRowId(boolean checker, String name) {
		return loginLogoutDetailsDao.getMaximumRowId(checker, name);
	}

	@Override
	public void roleupdate(int roleid, int userid) {
		// TODO Auto-generated method stub
		userDetailsDao.roleupdate(roleid,userid);
	}

	@Override
	public void deleterole(int roleid) {
		// TODO Auto-generated method stub
		userDetailsDao.deleterole(roleid);
		
	}
	
	@Override
	public void savePersonal(UserDetails userDetails) 
	{
		
		UserDetails entity=userDetailsDao.findById(userDetails.getUserrefno());
		if(entity != null){
			entity.setTitle(userDetails.getTitle());
			entity.setFirstName(userDetails.getFirstName());
			entity.setMiddleName(userDetails.getMiddleName());
			entity.setLastName(userDetails.getLastName());
			entity.setAlias(userDetails.getAlias());
		}
	}
	
	@Override
	public void updatePhtoPath(String name, String path, UserDetails userDetails) 
	{
		
		UserDetails entity=userDetailsDao.findById(userDetails.getUserrefno());
		if(entity != null){
			entity.setPhoto(path);
		}
	}
	
	@Override
	public void updateVideoPath(UserDetails userDetails) 
	{
		
		UserDetails entity=userDetailsDao.findById(userDetails.getUserrefno());
		if(entity != null){
			entity.setVideo(userDetails.getVideo());
		}
	}

}
