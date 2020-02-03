package com.beerrun.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beerrun.admin.dao.LoginLogoutDetailsDao;
import com.beerrun.model.LoginLogoutDetails;

@Service("loginlogoutservice")
@Transactional
public class LoginLogoutServiceImpl  implements LoginLogoutService{
	
	@Autowired
	private LoginLogoutDetailsDao loginlogoutdetails;

	@Override
	public List<LoginLogoutDetails> getuserloginouttime() {
		// TODO Auto-generated method stub
		
		return loginlogoutdetails.getuserinouttime();
	}

}
